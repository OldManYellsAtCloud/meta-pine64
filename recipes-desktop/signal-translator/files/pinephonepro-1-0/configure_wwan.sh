#!/bin/sh

response_file=`mktemp -p /tmp/`

COUNTER=0
IS_OK=FALSE

# try a few times, as initially it might be still registering,
# and not be ready on time
while [ $COUNTER -le 20 -a "$IS_OK" != "TRUE" ]; do

    dbus-send --system --dest=org.gspine.modem --type=method_call --print-reply=literal /org/gspine/modem org.gspine.modem.pd.get_connection_details string:"internet" > $response_file

    # check if response doesn't contain ERROR
    grep ERROR $response_file
    
    if [ $? -ne 1 ]; then
        COUNTER=$((COUNTER+1))
        sleep 1
    else
        IS_OK=TRUE
    fi
done

if [ "$IS_OK" = "FALSE" ]; then
    logger -t modem_setup -p 3 Could not parse network details: $response_file
    exit 1
fi

ip_addr=`jq -r '.["ip_address"]' < $response_file`/24
gateway=`jq -r '.["gateway"]' < $response_file`
dns1=`jq -r '.["dns1"]' < $response_file`
dns2=`jq -r '.["dns2"]' < $response_file`

rm $response_file
if [ -z "$gateway" ]; then
  gateway=`echo $ip_addr | cut -d. -f1-3`.1
fi

cp /etc/systemd/network/10-wwan.network.template /etc/systemd/network/10-wwan.network

sed -i "s@_IP_ADDR_@$ip_addr@g" /etc/systemd/network/10-wwan.network
sed -i "s/_GATEWAY_/$gateway/g" /etc/systemd/network/10-wwan.network
sed -i "s/_DNS1_/$dns1/g" /etc/systemd/network/10-wwan.network
sed -i "s/_DNS2_/$dns2/g" /etc/systemd/network/10-wwan.network
networkctl reload
networkctl reconfigure wwan0
qmi-network /dev/cdc-wdm0 start
qmicli --wds-set-autoconnect-settings=enabled -d /dev/cdc-wdm0

#!/bin/sh

response_file=`mktemp -p /tmp/`

COUNTER=0
IS_OK=FALSE

# try a few times, as initially it might be still registering,
# and not be ready on time
while [ $COUNTER -le 5 -a "$IS_OK" != "TRUE" ]; do

    dbus-send --system --dest=org.gspine.modem --type=method_call --print-reply /org/gspine/modem org.gspine.modem.pd.get_connection_details string:"internet" > $response_file

    # check if 2nd line contains "OK"
    head -n2 $response_file | tail -n1 | grep OK
    
    if [ $? -ne 0 ]; then
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

ip_addr=`head -n 6 $response_file | tail -n 1 | cut -d\" -f2`/24
gateway=`head -n 7 $response_file | tail -n 1 | cut -d\" -f2`
dns1=`head -n 8 $response_file | tail -n 1 | cut -d\" -f2`
dns2=`head -n 9 $response_file | tail -n 1 | cut -d\" -f2`

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

#!/bin/sh

# if there are symlinks already in the home folder,
# there is nothing else to do
if [ -L ${HOME}/.mozilla ]; then
  exit
fi

mkdir -p /data/${USER}_home/.ssh
ln -sf /data/${USER}_home/.ssh ${HOME}/.ssh
mkdir -p /data/${USER}_home/.mozilla
ln -sf /data/${USER}_home/.mozilla ${HOME}/.mozilla
mkdir -p /data/${USER}_home/.local
ln -sf /data/${USER}_home/.local ${HOME}/.local


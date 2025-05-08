#!/bin/bash
sudo apt update
sudo apt install -y openjdk-21-jdk unzip
curl -fsSL https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip
unzip awscliv2.zip
sudo ./aws/install

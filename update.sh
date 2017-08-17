#!/bin/bash
git status
echo "Please enter commit log" | lolcat
read log 
echo ""
echo $log | lolcat

git add --all | lolcat
git commit -m "$log" | lolcat

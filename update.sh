#!/bin/bash
git status
echo ""
echo ""
echo ""
echo "Please enter commit log" | lolcat
read log 
echo ""
echo $log | lolcat
echo ""
echo ""

echo "Sure to add and commit" | lolcat 
read confirm

echo ""

git add --all | lolcat
echo ""
echo ""
git commit -m "$log" | lolcat

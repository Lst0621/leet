#!/bin/bash
# try to generate sth useful in all problems
echo "Please enter folder name" | lolcat
read foldname
echo "Please enter package name" | lolcat
read packname
echo "Please enter url" | lolcat
read problem

mkdir -p "$foldname"/"$packname"

cd "$foldname"
cd "$packname"


echo ""
echo ""


echo //url:  "$problem" > Solution.java
echo package "$packname"";" >> Solution.java
tail -n+2 ../../9999-Temp/temp/Solution.java >> Solution.java

echo "file created" | lolcat 
echo ""
lolcat Solution.java
echo ""

pwd | lolcat


# add file path to ide
cd ../
cd ../

foldpath="<sourceFolder url=\"file://\$MODULE_DIR$/"$foldname"\" isTestSource=\"false\" />"
line=$(grep "/content" leet.iml -n | cut -f1 -d':')
sed -i "$line i \      $foldpath" leet.iml



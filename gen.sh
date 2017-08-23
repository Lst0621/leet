# try to generate sth useful in all problems
#!/bin/bash
echo "Please enter folder name" | lolcat
read foldname
echo "Please enter package name" | lolcat
read packname
echo "Please enter url" | lolcat
read problem

mkdir -p "$foldname"/"$packname"
cd "$foldname"
cd "$packname"


pwd | lolcat
echo ""
echo ""


echo //url:  "$problem" > Solution.java
echo package "$packname"";" >> Solution.java
tail -n+2 ../../9999-Temp/temp/Solution.java >> Solution.java

echo "file created" | lolcat 
echo ""
lolcat Solution.java
echo ""
pwd

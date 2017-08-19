echo delete all .class files
find . -name "*.class" | lolcat 
echo ""
echo ""
echo ""
echo Sure to delete? | lolcat
read confirm
find . -name "*.class" | xargs rm

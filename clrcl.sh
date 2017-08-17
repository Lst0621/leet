echo delete all .class files
find . -name "*.class" | lolcat 
read confirm
find . -name "*.class" | xargs rm

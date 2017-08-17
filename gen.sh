# try to generate sth useful in all problems
#!/bin/bash
mkdir -p "$1"/"$2"
cd "$1"
cd "$2"
echo //url:  "$3" > Solution.java
echo package "$2"";" >> Solution.java
tail -n+2 ../../9999-Temp/temp/Solution.java >> Solution.java
lolcat Solution.java

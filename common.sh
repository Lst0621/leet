cd util

find ./   -name "*.java" | xargs javac -cp ../util/*
for file in  $(find ./ -name "*.class" | sed -e "s/.\///") 
do
echo $file
cp --parents  $file ../target/
done


(
echo "Which folder? " | lolcat
echo ""
cnt=1
for fold in $(ls -dt */ | head -10)

do 
	echo $cnt $fold 
	cnt=$(expr $cnt + 1)
done) | lolcat


read foldnum
foldname=$(ls -dt */ | head -10| head -$foldnum | tail -1)
echo $foldname
cd "$foldname"

../jc.sh


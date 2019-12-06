x=1
while [ $x -le 1000 ];do
	make
	echo "----------Test n°"$x "du programme TestConvoyeur----------"
	x=$((x+1))
done

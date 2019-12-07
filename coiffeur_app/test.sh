x=1;
while [[ $x -le 100 ]]; do
	make;
	echo ---------Test n°$x ----------;
	x=$((x+1));
	sleep 3;
done
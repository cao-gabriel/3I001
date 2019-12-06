exec: all
	java -classpath bin:bin/graphic TestDessineLigne
	make clean
	clear
all: graphic
	javac src/*.java -d bin

graphic:
	javac src/graphic/*.java -d bin

clean:
	rm -rf bin/*

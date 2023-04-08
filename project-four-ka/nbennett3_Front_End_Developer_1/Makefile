run: compile
	./UWMadisonLotSearch.cgi

compile:
	javac --release 8 -cp junit5.jar *.java

test: compile
	java -jar junit5.jar -cp . --scan-classpath -n ParkingTestSuite

clean:
	$(RM) *.class

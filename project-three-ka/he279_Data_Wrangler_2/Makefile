run: compile
	java FlightApplication

compile:
	javac -cp .:junit5.jar *.java

test: compile
	java -jar junit5.jar --class-path . --scan-classpath --details tree

clean:
	$(RM) *.class

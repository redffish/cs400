run: compile
	@echo running application...
	java FlightApplication
	

compile:
	@echo compiling code...
	javac AirportGraph.java
	javac CS400Graph.java
	javac Data.java
	javac FlightApplication.java
	javac GraphADT.java
	@echo finished!

test:
	@echo testing code...
	javac -cp .:junit5.jar TestFlightApplication.java
	java -jar junit5.jar -cp . --scan-classpath -n TestFlightApplication
	@echo finished!

clean:
	$(RM) *.class

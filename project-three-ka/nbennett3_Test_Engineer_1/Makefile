  
run: compile
	 @echo "Compiling and running the Flight Manager Application."
	java FlightOptimizationDriver

compile:
	@echo "Compiling source files..."
	javac -cp .:junit5.jar *.java
	@echo "All source files compiled!"

test: compile
        @echo "Running the TestFlightApplication..."
        javac -cp .:junit5.jar TestFlightApplication.java
        @echo "Tests Complete!"

clean:
	@echo "Tidying up..."
	$(RM) *.class

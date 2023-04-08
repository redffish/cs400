run: compile
        java FlightOptimizationDriver

compile:
        javac AirportGraph.java
        javac CS400Graph.java
        javac DataProcessor.java
        javac FlightOptimizationDriver.java
        javac GraphADT.java

test:
        javac -cp .:junit5.jar TestFlightApplication.java
        java -jar junit5.jar -cp . --scan-classpath -n TestFlightApplication

clean:
        $(RM) *.class

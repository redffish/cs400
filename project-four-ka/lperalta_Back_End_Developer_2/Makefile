run: compile
        ./UWMadisonLotSearch.cgi

compile:
        javac --release 8 P4Webpage.java ParkingBackEnd.java SearchLots.java

test:
        javac --release 8 -cp .:junit5.jar ParkingTestSuite.java
        java -jar junit5.jar -cp . --scan-classpath -n ParkingTestSuite

clean:
        $(RM) *.class
 

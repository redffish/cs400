// --== CS400 File Header Information ==--
// Name: Joseph Reuss
// Email: jrreuss@wisc.edu
// Team: KA
// TA: Sid
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;

/**
 * This class ensures that AirportGraph.java works correctly
 * 
 * @author Joseph Reuss
 *
 */
public class TestFlightApplication {
  private CS400Graph cs400Graph;
  private AirportGraph testGraph;
  private Data fileData;

  @BeforeEach
  // create a graph before each test, always inserting flights and airports from flights.txt before
  // the test
  public void createGraph() {
    testGraph = new AirportGraph();
    fileData = new Data("flights.txt");

    try {
      fileData.loadFile(testGraph);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }


  }

  /**
   * will add an airport to the set and test that the insertAirport and containsAirport methods work
   * properly
   */
  @Test
  public void testInsertAirport() {
    assertTrue(testGraph.insertAirport("AAA")); // tests just generally adding an Airport
    assertTrue(testGraph.containsAirport("AAA")); // tests to ensure the airport was added
                                                  // successfully
  }

  /**
   * will add a flight to the set and test that the insertFlight and containsFlight methods work
   * properly
   */
  @Test
  public void testInsertFlight() {
    testGraph.insertAirport("AAA");
    assertTrue(testGraph.insertFlight("AAA", "JFK", 15)); // tests generally adding a flight
    assertTrue(testGraph.containsFlight("AAA", "JFK")); // tests to ensure the flight was added
                                                        // successfully
  }

  /**
   * will add a select number of airports to the set and test that the getAirportCount method
   * returns the correct number
   */
  @Test
  public void testAirportCount() {
    // insert multiple more airports to increase the number of them
    testGraph.insertAirport("AAA");
    testGraph.insertAirport("IDK");
    testGraph.insertAirport("CAT");
    testGraph.insertAirport("RED");
    testGraph.insertAirport("GOD");
    assertTrue(testGraph.getAirportCount() == 15); // ensures that the number of airports in the
                                                   // graph are correct
  }

  /**
   * will add a select number of flights to the set and test that the getFlightCount method returns
   * the correct number
   */
  @Test
  public void testFlightCount() {
    // insert multiple more airports
    testGraph.insertAirport("AAA");
    testGraph.insertAirport("IDK");
    testGraph.insertAirport("CAT");
    testGraph.insertAirport("RED");
    testGraph.insertAirport("DOG");
    // insert more flights connecting these newly added airports
    testGraph.insertFlight("AAA", "CAT", 2);
    testGraph.insertFlight("AAA", "RED", 5);
    testGraph.insertFlight("DOG", "JFK", 3);
    testGraph.insertFlight("RED", "DOG", 2);
    testGraph.insertFlight("RED", "IDK", 2);

    assertTrue(testGraph.getFlightCount() == 44); // ensures that the number of flights in the
                                                  // graph are correct
  }

  /**
   * using the flights.txt file, this method will test the shortest path between 3 different origins
   * and destinations.
   */
  @Test
  public void testShortestPath() {
    // test 3 different shortest paths of different lengths and ensure they are the actual shortest
    // path
    assertTrue(testGraph.getShortestPath("ATL", "DFW").toString().equals("ATL -> DFW (2h)"));
    assertTrue(
        testGraph.getShortestPath("MIA", "SEA").toString().equals("MIA -> ATL -> DEN -> SEA (7h)"));
    assertTrue(
        testGraph.getShortestPath("ORD", "SFO").toString().equals("ORD -> DEN -> LAS -> SFO (5h)"));

  }

  /**
   * this test will add 3 flights and test their duration is stored and retrieved accurately using
   * the getFlightTime method. It will also test 5 flight durations using the flights.txt file.
   */
  @Test
  public void testFlightDuration() {
    // insert multiple more airports
    testGraph.insertAirport("AAA");
    testGraph.insertAirport("IDK");
    testGraph.insertAirport("CAT");
    testGraph.insertAirport("RED");
    testGraph.insertAirport("DOG");
    // insert more flights connecting these newly added airports
    testGraph.insertFlight("AAA", "CAT", 2);
    testGraph.insertFlight("AAA", "RED", 5);
    testGraph.insertFlight("DOG", "JFK", 3);
    testGraph.insertFlight("RED", "DOG", 2);
    testGraph.insertFlight("RED", "IDK", 6);
    // tests 3 cases of the recently added flights
    assertTrue(testGraph.getFlightTime("AAA", "CAT") == 2);
    assertTrue(testGraph.getFlightTime("DOG", "JFK") == 3);
    assertTrue(testGraph.getFlightTime("RED", "DOG") == 2);

    // tests 5 cases of the flights in flights.txt
    assertTrue(testGraph.getFlightTime("ATL", "LAX") == 4);
    assertTrue(testGraph.getFlightTime("DEN", "DFW") == 2);
    assertTrue(testGraph.getFlightTime("SEA", "SFO") == 2);
    assertTrue(testGraph.getFlightTime("LAX", "SFO") == 1);
    assertTrue(testGraph.getFlightTime("MIA", "DFW") == 2);

  }


}

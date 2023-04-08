// --== CS400 File Header Information ==--
// Name: Nicole Bennett
// Email: nbennett3@wisc.edu
// Team: KA
// TA: Siddharth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: none

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

/**
 * This class tests that the AirportGraph and Data Processor classes work as
 * expected.
 * 
 * @author NicoleBennett
 *
 */
public class TestFlightApplication {
	private AirportGraph testAG;

	/**
	 * Creates a test airport graph before each test method is called.
	 */
	@BeforeEach
	public void createAiportGraph() {
		this.testAG = new AirportGraph();
	}

	/**
	 * Adds an airport to the test airport graph and tests that the insertAirport,
	 * containsAirport, and getAirportCount methods work properly.
	 */
	@Test
	public void testAddAirport() {
		testAG.insertAirport("MSN");
		assertTrue(testAG.containsAirport("MSN") && testAG.getAirportCount() == 1);
	}

	/**
	 * Adds a flight to the test airport graph and tests that the insertFlight,
	 * containsFlight, getAirportCount, and getFlightCount methods work properly.
	 */
	@Test
	public void testAddFlight() {
		testAG.insertAirport("MSN");
		testAG.insertAirport("ORD");
		testAG.insertFlight("MSN", "ORD", 1);
		assertTrue(testAG.containsFlight("MSN", "ORD") && testAG.getFlightCount() == 1);
		assertTrue(testAG.getAirportCount() == 2);
	}

	/**
	 * Adds 5 airports to the test airport graph and tests that the getAirportCount
	 * method returns the correct number.
	 */
	@Test
	public void testAirportCount() {
		testAG.insertAirport("MSN");
		testAG.insertAirport("ORD");
		testAG.insertAirport("LGB");
		testAG.insertAirport("LAX");
		testAG.insertAirport("SFO");
		assertTrue(testAG.getAirportCount() == 5);
	}

	/**
	 * Adds 5 flights to the test airport graph and tests that the getFlightCount
	 * method returns the correct number.
	 */
	@Test
	public void testFlightCount() {
		testAG.insertAirport("MSN");
		testAG.insertAirport("ORD");
		testAG.insertAirport("JFK");
		testAG.insertAirport("LAX");
		testAG.insertAirport("SFO");
		testAG.insertFlight("MSN", "ORD", 1);
		testAG.insertFlight("MSN", "LAX", 4);
		testAG.insertFlight("SFO", "JFK", 5);
		testAG.insertFlight("MSN", "JFK", 3);
		testAG.insertFlight("SFO", "ORD", 4);
		assertTrue(testAG.getFlightCount() == 5);
	}

	/**
	 * Using the flights.txt file, this method tests the shortest path between 3
	 * different origins and destinations.
	 */
	@Test
	public void testShortestPath() {
		DataProcessor dp = new DataProcessor();
		try {
			dp.loadFile(testAG, "flights.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		assertTrue(testAG.getFlightCount() == 36);
		assertTrue(testAG.getShortestPath("SFO", "HND").toString().equals("SFO -> HND (11h)"));
		assertTrue(testAG.getShortestPath("MIA", "JFK").toString().equals("MIA -> DFW -> JFK (6h)"));
		assertTrue(testAG.getShortestPath("SEA", "PEK").toString().equals("SEA -> HND -> PEK (13h)"));

	}

	/**
	 * Adds 3 flights and tests their duration is stored and retrieved accurately
	 * using the getFlightTime method. Also tests 5 flight durations using the
	 * flights.txt file.
	 */
	@Test
	public void testFlightDuration() {

		DataProcessor dp = new DataProcessor();
		try {
			dp.loadFile(testAG, "flights.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		testAG.insertAirport("ICN");
		testAG.insertAirport("LHR");
		testAG.insertAirport("JNB");
		testAG.insertFlight("ICN", "LHR", 11);
		testAG.insertFlight("ICN", "JFK", 14);
		testAG.insertFlight("JNB", "LAX", 21);
		assertTrue(testAG.getFlightTime("ICN", "LHR") == 11);
		assertTrue(testAG.getFlightTime("ICN", "JFK") == 14);
		assertTrue(testAG.getFlightTime("JNB", "LAX") == 21);

		// test from flights.txt file
		assertTrue(testAG.getFlightTime("ATL", "LAX") == 4);
		assertTrue(testAG.getFlightTime("MIA", "DFW") == 3);
		assertTrue(testAG.getFlightTime("ORD", "TPA") == 2);
		assertTrue(testAG.getFlightTime("DFW", "JFK") == 3);
		assertTrue(testAG.getFlightTime("ATL", "LAX") == 4);
	}

}

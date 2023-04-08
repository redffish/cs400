// --== CS400 File Header Information ==--
// Name: Connor Kolb
// Email: cwkolb@wisc.edu
// Team: KA
// Role: Data Wrangler 1
// TA: Sid
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class imports a list of flight routes into an AirportGraph object
 * 
 * @author Connor Kolb
 *
 */
public class DataProcessor {

    /**
     * Loads the list of flights into the AirportGraph object
     * 
     * @param airport   - airport object to add the routes to
     * @param filenName - name of the file containing flight routes
     * @throws FileNotFoundException - when the file cannot be found
     */
    public void loadFile(AirportGraph airport, String fileName) throws FileNotFoundException {
        File flightData = new File(fileName);
        Scanner scanner = new Scanner(flightData);
        while (scanner.hasNextLine()) {
            // format the input into an array
            String[] flightInfo = scanner.nextLine().trim().split(",");
            String start = flightInfo[0].trim();
            String destination = flightInfo[1].trim();
            int weight = Integer.parseInt(flightInfo[2].trim());
            // ensure the start and destination airports are in the object
            if (!airport.containsAirport(start)) {
                airport.insertAirport(start);
            }
            if (!airport.containsAirport(destination)) {
                airport.insertAirport(destination);
            }
            // add the fight 
            airport.insertFlight(start, destination, weight);
        }
        scanner.close();
    }

}
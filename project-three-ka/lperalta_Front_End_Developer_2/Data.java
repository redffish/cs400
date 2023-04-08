
// --== CS400 File Header Information ==--
// Name: Jiaqi He
// Email: he279@wisc.edu
// Team: KA
// Role: Data Wrangler 2
// TA: Sid
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class loads data in a file into our application.
 * 
 * @author Jiaqi He
 *
 */
public class Data {
  private String path;

  /**
   * Constructor.
   * 
   * @param path the path of the file to be loaded
   */
  public Data(String path) {
    this.path = path;
  }

  /**
   * Load data into an AirportGraph object
   * 
   * @param graph
   * @throws FileNotFoundException
   */
  public void loadFile(AirportGraph graph) throws FileNotFoundException {
      File flightData = new File(path);
      Scanner scanner = new Scanner(flightData);
      while (scanner.hasNextLine()) {
        String[] line = scanner.nextLine().trim().split(",");
        String start = line[0].trim();
        String dest = line[1].trim();
        int weight = Integer.parseInt(line[2].trim());
        graph.forceInsertFlight(start, dest, weight);
      }
      scanner.close();
  }

}

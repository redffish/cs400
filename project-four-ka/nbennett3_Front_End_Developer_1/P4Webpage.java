// --== CS400 File Header Information ==--
// Name: Nicole Bennett
// Email: nbennett3@wisc.edu
// Team: KA
// Role: Front End Developer 1
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: My groupmate, Owen Graham, helped me integrate the front with 
// the back end and spent a lot of time helping me troubleshoot server issues. If
// there's extra credit to be had for this assignment, he deserves it!

import java.util.StringJoiner;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class P4Webpage {

   /**
     * Convert ParkingLot info to HTML.
     *
     * @param lot - the lot to be converted.
     */
    private static String lotToHTML(ParkingLot lot) {
	int lotNumber = lot.lotNumber;
	String lotAddress = lot.address;
	int lotCapacity = lot.capacity;
	int lotOccupied = lot.occupied;
	int[] nearby = lot.nearby;

        StringJoiner nearbyJoiner = new StringJoiner(", ");
        for (int i : nearby) {
            nearbyJoiner.add(String.valueOf(i));
        }

	return "<p><b>Lot #" + lotNumber + ": </b>" + lotAddress + "<br>" +
	    "There are " + lotOccupied + " spaces occupied out of " + lotCapacity +
	    " available spaces." + "<br>" + "<i>If this lot is full, try these nearby lots: "
	    + nearbyJoiner.toString() + "</i></p><hr>";
    }
    
   /**
     * Main method takes search query as argument and sends it
     * to the backend to retrieve lot info.
     *
     * @param args - search query from HTML form.
     */
    public static void main(String[] args) {
	    
	// Input CSV file to backend, sort lots by the desired, queried lot,
	// and if lots match query, return matching lots. If lots don't match
	// query. Send error message.
    try {
	ParkingBackEnd pbe = new ParkingBackEnd();
	pbe.inputData();
	String lotAddress = java.net.URLDecoder.decode(args[0].replaceAll("^search=", ""), "UTF-8");
	List<ParkingLot> potLots = pbe.sort(lotAddress);
	
	System.out.println("<p>You searched for Lot #" + lotAddress + "<p>");

	if (potLots.size() == 0) {
	    System.out.println("<p>Sorry. There are no lots that match your query.</p>");
	}
	for (ParkingLot lot : potLots) {
	    System.out.println(lotToHTML(lot));
	}
	// Catch errors thrown by the try block and convert error message to HTML.
    } catch(Exception e) {
	System.out.println("<html><body><pre>");
	System.out.println("Ooops, something went wrong. There was an exception in the Java program:");
	e.printStackTrace(System.out);
	System.out.println("</pre></body></html>");
    }

  }
}


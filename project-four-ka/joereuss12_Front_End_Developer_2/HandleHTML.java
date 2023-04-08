// --== CS400 File Header Information ==--
// Name: Joseph Reuss
// Email: jrreuss@wisc.edu
// Team: KA
// Role: Front End Developer 2
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes> 
import java.util.List;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;

public class HandleHTML {
  
  /**
   * This method is used to return a string in HTML of all of the available parking lots
   * 
   * @return a string of a parking lot and its info in HTML
   */
  public static String lotToHTML(ParkingLot lot) {
    //split strings every new line so the look neater on the webpage
    String[] lotStrings = lot.toString().split("\\n");
    String returnString = "";
    //make a new paragraph so each new line is actually on a new line in HTML
    for (int i = 0; i < lotStrings.length; i++) {
      returnString += "<p>" +  lotStrings[i] + "</p>";
    }    
    return returnString + "<br>";
  }
  
  /**
   * Main method to load in HTML code using methods in java devloped by the backend
   *
   */
  public static void main(String[] args) {
  try {
    //initiallizing a ParkingBackEnd object and loading in data into a list
    ParkingBackEnd parking = new ParkingBackEnd();
    parking.inputData();

    //making the lot address whatever the user searches on the webpage
    String lotAddress = java.net.URLDecoder.decode(args[0].replaceAll("^search=", ""), "UTF-8");
    List<ParkingLot> pLots = parking.sort(lotAddress);


    System.out.println("Searched: " + lotAddress + "<br>");
    
    //if nothing matches what is searches, state no lots found :(
    if (pLots.size() == 0) {
      System.out.println("<p> No lots found :(</p>");
    }
    //loop through and find all matching lots to display to user
    else {
      for (ParkingLot lot : pLots) {	    
      System.out.println(lotToHTML(lot));
      }
    }
  } catch (Exception e) { //catch exception if something goes wrong and printing it it the webpage
      System.out.println("<html><body><pre>");
      System.out.println("There is an exception in the java program!");
      e.printStackTrace(System.out);
      System.out.println("</pre></body></html>");
  }    
  }
}


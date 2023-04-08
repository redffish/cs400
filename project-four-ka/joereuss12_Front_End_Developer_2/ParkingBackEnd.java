// --== CS400 File Header Information ==--
// Name: Lillian Peralta
// Email: lperalta@wisc.edu
// Team: KA
// TA: Sid
// Lecturer: Florian Heimerl
// Notes to Grader: N/A
/*
 * @author Lillian Peralta
 */
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Backend implementation made to create a list of ParkingLot objects
 * that can be added, removed, or searched for.
 * @author lillyperalta
 *
 */
public class ParkingBackEnd {

   List<ParkingLot> lots = new LinkedList<ParkingLot>();

	/**
	 * Inputs parking lot data provided by Data Wranglers into a LinkedList to be used by the Frontend for searching.
	 * @throws FileNotFoundException if file is invalid
	 */
	public void inputData() {
      try {
          File file = new File("parking.csv"); // using owen graham's csv file
          Scanner scnr = new Scanner(file);
          // Scanner stores an array of the data seperated by commas
          scnr.nextLine(); // skip since is header
          while (scnr.hasNextLine()) {

              String ln = scnr.nextLine();
              String lnArr[] = ln.split(",");
              // Data is parsed to specific values based on the datatype we want to use to
              // store in the hashtable
              String addres = lnArr[0];
              
              int lotNum = Integer.parseInt(lnArr[1]);
              int lotCap = Integer.parseInt(lnArr[2]);
              int occu = Integer.parseInt(lnArr[3]);              
              int[] nearLots = new int[3];
              int lnidx = 4;
              for(int i = 0; i < nearLots.length; i++) {
                  nearLots[i] = Integer.parseInt(lnArr[lnidx]);
                  lnidx++;
              }
              // Employee record object is made using data from the file given
              ParkingLot record = new ParkingLot(addres, lotNum, lotCap, occu, nearLots);
              // the id is stored as the key and the record is stored as the value in the hashtable
              lots.add(record);
          }
          scnr.close();
      }
          catch(FileNotFoundException e) {
              System.out.println("Try a different file couldn't recognize");
          }

      
  }
	
	/**
	 * Returns a string representation of the LinkedList of ParkingLot objects.
	 */
	@Override
	public String toString() {
		String lotStr = "";
		for(ParkingLot lot : this.lots) {
			lotStr += lot.toString() + "\n";
		}
		return lotStr;
		
	}
	
	/**
	 * Returns a list of ParkingLot objects containing the search string.
	 * @param search String to search for in the address of the parking lots
	 * @return List of parking lots containing the string to search for
	 */
	public List<ParkingLot> sort(String search){
		return SearchLots.sort(lots  , search);
	}
	
	/**
	 * Returns a string representation of the list of ParkingLot objects returned after search.
	 * @param search String of lot to be searched for
	 * @return String searchResults of ParkingLot objects that result from the search. 
	 */
	public String sortedPotLots(String search) {
		String searchResults = "";
		for(ParkingLot lot : sort(search)) {
			searchResults += lot.toString() + "\n";
		}
		return searchResults;
	}
	
	/**
	 * Adds a ParkingLot object into the lotRecord list of Parkinglot objects.
	 * @param newLot the ParkingLot to add
	 * @return true when lot is successfully added and false if otherwise
	 */
	public boolean addLot(ParkingLot newLot) {
		return lots.add(newLot);
	}
	/**
	 * Removes a ParkingLot object from lotRecord list.
	 * @param removed the ParkingLot object to be removed
	 * @return true when parking lot is successfully removed and false if otherwise
	 */
	public boolean removeLot(ParkingLot removed) {
		return lots.remove(removed);
	}
	
	/**
	 * Returns a ParkingLot object wanted from the lotRecord list.
	 * @param lot the ParkingLot object to get 
	 * @return a ParkingLot object when successfully found and null if otherwise
	 */
	public ParkingLot getLot(ParkingLot lot) {
		for(int i = 0; i < lots.size(); i++) {
			ParkingLot current = lots.get(i);
			if(current.equals(lot)) {
				return current;
			}
		}
		return null;
	}
		
}

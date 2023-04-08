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

	List<ParkingLot> lotRecord = new LinkedList<ParkingLot>();

	/**
	 * Inputs parking lot data provided by Data Wranglers into a LinkedList to be used by the Frontend for searching.
	 * @throws FileNotFoundException if file is invalid
	 */
	public void inputData() throws FileNotFoundException{
		File parkingData = new File("parking.csv");
		Scanner scanner = new Scanner(parkingData);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String[] line = scanner.nextLine().trim().split(",");
			int[] arr = new int[]{Integer.parseInt(line[4]), Integer.parseInt(line[5]), Integer.parseInt(line[6])};  //array of nearby lots
			ParkingLot lot = new ParkingLot(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), 
					Integer.parseInt(line[3]), arr);
			
			lotRecord.add(lot); //adds new lot to LinkedList
		}
		scanner.close();
	}
	
	/**
	 * Returns a string representation of the LinkedList of ParkingLot objects.
	 */
	@Override
	public String toString() {
		String lotStr = "";
		for(ParkingLot lot : this.lotRecord) {
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
		return SearchLots.sort(lotRecord, search);
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
		return lotRecord.add(newLot);
	}
	/**
	 * Removes a ParkingLot object from lotRecord list.
	 * @param removed the ParkingLot object to be removed
	 * @return true when parking lot is successfully removed and false if otherwise
	 */
	public boolean removeLot(ParkingLot removed) {
		return lotRecord.remove(removed);
	}
	
	/**
	 * Returns a ParkingLot object wanted from the lotRecord list.
	 * @param lot the ParkingLot object to get 
	 * @return a ParkingLot object when successfully found and null if otherwise
	 */
	public ParkingLot getLot(ParkingLot lot) {
		for(int i = 0; i < lotRecord.size(); i++) {
			ParkingLot current = lotRecord.get(i);
			if(current.equals(lot)) {
				return current;
			}
		}
		return null;
	}
		
}


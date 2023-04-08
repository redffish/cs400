// --== CS400 File Header Information ==--
// Name: Liam Jogal
// Email: ljogal@wisc.edu
// Team: KA
// Role: Back End Developer 1
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;

/**
 * BackEnd class that contains a list of ParkingLots. Allows user to add remove and get
 * @author Liam Jogal
 *
 */
public class ParkingBackEnd {
	// Used to store all of the parking lots
	List<ParkingLot> lots = new LinkedList<ParkingLot>();
	
	/**
	 * Inputs data into the hashtable if the user wants data provided.
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
	 * Inserts a parking lot into the parkinglot list where all parking lots are stored
	 * @param add  - ParkingLot to add into list of lots
	 * @return True when lot successfully added and false otherwise
	 */
	public boolean addLot(ParkingLot add) {
		return this.lots.add(add);
	}
	/**
	 * Removes a parking lot from list of parking lots
	 * @param rem - ParkingLot this is to be removed
	 * @return True when parking lot successfully removed and false otherwise
	 */
	public boolean removeLot(ParkingLot rem) {
		return this.lots.remove(rem);
	}
	
	/**
	 * Returns a desired parking lot from the list of lots
	 * @param retrieve - Parking lot that user wants
	 * @return a ParkingLot object when successfully retrieved and null otherwise
	 */
	public ParkingLot getLot(ParkingLot retrieve) {
		for(int i = 0; i<lots.size(); i++) {
			ParkingLot check = lots.get(i);
			if(check.equals(retrieve)) {
				return check;
			}
		}
		return null;
	}
	
	/**
	 * Returns a string representation of all the lots 
	 */
	@Override
	public String toString() {
		String ret = "";
		
		for(ParkingLot lot : this.lots) {
			ret += lot.toString() + "\n";
		}
		return ret;
		
	}
	
	/**
	 * Return a list of parking lots containing the string to search for in address 
	 * @param search - String to search for in the address of the parking lots
	 * @return List of parking lots containing the string to search for
	 */
	public List<ParkingLot> sort(String search){
		return SearchLots.sort(this.lots, search);
	}
	
	/**
	 * Returns lots that contain a certain string 
	 * @param search - String to serch for
	 * @return string that contains all the lots that contain the search word in there address
	 */
	public String sortedPotLots(String search) {
		String ret = "";
		for(ParkingLot lot : sort(search)) {
			ret += lot.toString() + "\n";
		}
		return ret;
	}
	

}

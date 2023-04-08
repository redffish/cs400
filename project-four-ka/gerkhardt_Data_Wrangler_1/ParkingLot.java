// --== CS400 File Header Information ==--
// Name: Adam Gerkhardt
// Email: gerkhardt@wisc.edu
// Team: KA
// Role: Data Wrangler 1
// TA: Sid
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes> 


/**
 *  ParkingLot object
 */
public class ParkingLot {

    public String address;
    public int lotNumber;
    public int capacity;
    public int occupied;
    public int[] nearby;
    
    /**
     *  Create and initialize ParkingLot object
     *  
     * @param address is the address as a String of the parking lot
     * @param lot is the int of the lot number
     * @param capacity is the int of the max capacity of the parking lot
     * @param occupied is the int of the currently occupied spots in the parking lot
     * @param nearby is the group of nearby parking lots, based on their number
     */
    public ParkingLot(String address, int lot, int capacity, int occupied, int[] nearby) {
      this.address = address;
      this.lotNumber = lot;
      this.capacity = capacity;
      this.occupied = occupied;
      this.nearby = nearby;
    }
    
    /* 
     * This formats and displays the ParkingLot object as a string
     * It follows the format as: Lot 1, 123 St. (0 out of 10 spots filled) (Nearby: 1, 2, 3)
     */
    public String toString() {
      String near = "";
      
      for (int i = 0; i < nearby.length; i++) {
       if (i == nearby.length - 1) {
         near = near + "" + nearby[i];
       }
       else {
         near = near + "" + nearby[i] + ", ";
       }
      }
      return String.format("Lot #%d, %s (%d out of %d spots filled) (Nearby: %s)", lotNumber,
          address, occupied,capacity, near);
    }
    
}

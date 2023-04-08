// --== CS400 File Header Information ==--
// Name: Owen Graham
// Email: ohgraham@wisc.edu
// Team: KA
// Role: Data Wrangler 2
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.StringJoiner;

/**
 * Parking lot data object.
 */
public class ParkingLot {

    public String address;
    public int lotNumber;
    public int capacity;
    public int occupied;
    public int[] nearby;

    /**
     * Initialize with the necessary data.
     *
     * @param address Street address
     * @param lotNumber Lot number
     * @param capacity Total number of parking spots
     * @param occupied Number of parking spots currently occupied
     * @param nearby Lot numbers of nearby lots
     */
    public ParkingLot(String address, int lotNumber, int capacity,
                      int occupied, int[] nearby) {
        this.address = address;
        this.lotNumber = lotNumber;
        this.capacity = capacity;
        this.occupied = occupied;
        this.nearby = nearby;
    }

    /**
     * Display all fields as a readable string.
     * Like "Lot #4: 445 Easterday Lane (0/478 spots full) (nearby: 125,
     * 124, 123)".
     */
    public String toString() {
        StringJoiner nearbyJoiner = new StringJoiner(", ");
        for (int i : nearby) {
            nearbyJoiner.add(String.valueOf(i));
        }
        return String.format("Lot #%d: %s (%d/%d spots full) (nearby: %s)",
                             lotNumber, address, occupied, capacity,
                             nearbyJoiner.toString());
    }

}

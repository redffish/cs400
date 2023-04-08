// --== CS400 File Header Information ==--
// Name: Jiaqi He
// Email: he279@wisc.edu
// Team: KA
// Role: Test Engineer 2
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader:

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * This test suite ensures ParkingBackEnd.java works correctly
 * 
 * @author Jiaqi He
 *
 */
public class ParkingTestSuite {
  private ParkingBackEnd pbe;
  
  /**
   * Call constructor and input data before each test
   */
  @BeforeEach
  public void init() {
    pbe = new ParkingBackEnd();  
    try {
      pbe.inputData();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Test addLot() method
   */
  @Test
  public void testAddLot() {
    int[] nearby1 = new int[] {5,6,7};
    int[] nearby2 = new int[] {6,7,8};
    ParkingLot lot1 = new ParkingLot("100 Some Street", 1, 100, 10, nearby1);
    ParkingLot lot2 = new ParkingLot("200 Some Street", 2, 200, 20, nearby2);
    assertTrue(pbe.addLot(lot1));
    assertTrue(pbe.addLot(lot2));
  }
  
  /**
   * Test removeLot() method
   */
  @Test
  public void testRemoveLot() {
    int[] nearby1 = new int[] {5,6,7};
    int[] nearby2 = new int[] {6,7,8};
    ParkingLot lot1 = new ParkingLot("100 Some Street", 1, 100, 10, nearby1);
    ParkingLot lot2 = new ParkingLot("200 Some Street", 2, 200, 20, nearby2);
    pbe.addLot(lot1);
    pbe.addLot(lot2);
    assertTrue(pbe.removeLot(lot2));
    assertTrue(pbe.removeLot(lot1));  
  }
  
  /**
   * Test getLot() method
   */
  @Test
  public void testGetLot() {
    int[] nearby1 = new int[] {5,6,7};
    int[] nearby2 = new int[] {6,7,8};
    ParkingLot lot1 = new ParkingLot("100 Some Street", 1, 100, 10, nearby1);
    ParkingLot lot2 = new ParkingLot("200 Some Street", 2, 200, 20, nearby2);
    pbe.addLot(lot1);
    pbe.addLot(lot2);
    assertTrue(pbe.getLot(lot2).equals(lot2));
    assertTrue(pbe.getLot(lot1).equals(lot1));
  }
  
  /**
   * Test sort() method
   */
  @Test
  public void testSort() {
    assertEquals("[Lot #10: 1001 Observatory Drive "
        + "(16/62 spots full) (nearby: 9, 6, 8), "
        + "Lot #131: 1100-1200 Block University Bay Drive "
        + "(108/496 spots full) (nearby: 130, 135, 82)]", pbe.sort("100").toString());
    
    assertEquals("[Lot #130: 2003 University Bay Drive "
        + "(142/178 spots full) (nearby: 131, 135, 76), "
        + "Lot #33: 130 N. Mills Street "
        + "(216/470 spots full) (nearby: 45, 53, 51), "
        + "Lot #131: 1100-1200 Block University Bay Drive "
        + "(108/496 spots full) (nearby: 130, 135, 82), "
        + "Lot #80: 1308 W. Dayton Street "
        + "(90/263 spots full) (nearby: 113, 13, 54), "
        + "Lot #113: 1300 W. Dayton Street "
        + "(30/57 spots full) (nearby: 80, 13, 54)]", pbe.sort("130").toString());
  }

}

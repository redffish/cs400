// --== CS400 File Header Information ==--
// Name: Connor Kolb
// Email: cwkolb@wisc.edu
// Team: KA
// Role: Test Engineer 1
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ParkingTestSuite {

	/**
	 * Implemented using JUnit in order to test the addLot() feature implemented by the back-end developers
	 */
	@Test
	void testAddLot() {
		ParkingBackEnd back = new ParkingBackEnd();
		int[] tempNearby = { 1, 2, 3 };
		ParkingLot lotTest1 = new ParkingLot("123 University Ave.", 4, 50, 25, tempNearby);
		assertTrue(back.addLot(lotTest1) && back.lots.size() == 1);
		ParkingLot lotTest2 = new ParkingLot("987 Langond St.", 10, 500, 125, tempNearby);
		assertTrue(back.addLot(lotTest2) && back.lots.size() == 2);
		int[] tempNearby2 = { 5, 2, 8 };
		ParkingLot lotTest3 = new ParkingLot("384 Mifflin St.", 13, 100, 25, tempNearby2);
		assertTrue(back.addLot(lotTest3) && back.lots.size() == 3);
		ParkingLot lotTest4 = new ParkingLot("592 Johnson St.", 20, 250, 125, tempNearby2);
		assertTrue(back.addLot(lotTest4) && back.lots.size() == 4);
		int[] tempNearby3 = { 1, 2, 3 };
		ParkingLot lotTest5 = new ParkingLot("390 Mifflin St.", 40, 400, 250, tempNearby3);
		assertTrue(back.addLot(lotTest5) && back.lots.size() == 5);
		ParkingLot lotTest6 = new ParkingLot("2034 State St.", 11, 750, 365, tempNearby3);
		assertTrue(back.addLot(lotTest6) && back.lots.size() == 6);
		int[] tempNearby4 = { 5, 2, 8 };
		ParkingLot lotTest7 = new ParkingLot("925 State St.", 16, 75, 25, tempNearby4);
		assertTrue(back.addLot(lotTest7) && back.lots.size() == 7);
		ParkingLot lotTest8 = new ParkingLot("283 Basset St.", 24, 250, 75, tempNearby4);
		assertTrue(back.addLot(lotTest8) && back.lots.size() == 8);
	}

	/**
	 * Implemented using JUnit in order to test the removeLot() feature implemented by the back-end developers
	 */
	@Test
	void testRemoveLot() {
		// add the lots
		ParkingBackEnd back = new ParkingBackEnd();
		int[] tempNearby = { 1, 2, 3 };
		ParkingLot lotTest1 = new ParkingLot("123 University Ave.", 4, 50, 25, tempNearby);
		assertTrue(back.addLot(lotTest1) && back.lots.size() == 1);
		ParkingLot lotTest2 = new ParkingLot("987 Langond St.", 10, 500, 125, tempNearby);
		assertTrue(back.addLot(lotTest2) && back.lots.size() == 2);
		int[] tempNearby2 = { 5, 2, 8 };
		ParkingLot lotTest3 = new ParkingLot("384 Mifflin St.", 13, 100, 25, tempNearby2);
		assertTrue(back.addLot(lotTest3) && back.lots.size() == 3);
		ParkingLot lotTest4 = new ParkingLot("592 Johnson St.", 20, 250, 125, tempNearby2);
		assertTrue(back.addLot(lotTest4) && back.lots.size() == 4);
		int[] tempNearby3 = { 1, 2, 3 };
		ParkingLot lotTest5 = new ParkingLot("390 Mifflin St.", 40, 400, 250, tempNearby3);
		assertTrue(back.addLot(lotTest5) && back.lots.size() == 5);
		ParkingLot lotTest6 = new ParkingLot("2034 State St.", 11, 750, 365, tempNearby3);
		assertTrue(back.addLot(lotTest6) && back.lots.size() == 6);
		int[] tempNearby4 = { 5, 2, 8 };
		ParkingLot lotTest7 = new ParkingLot("925 State St.", 16, 75, 25, tempNearby4);
		assertTrue(back.addLot(lotTest7) && back.lots.size() == 7);
		ParkingLot lotTest8 = new ParkingLot("283 Basset St.", 24, 250, 75, tempNearby4);
		assertTrue(back.addLot(lotTest8) && back.lots.size() == 8);
		// remove a few
		assertTrue(back.removeLot(lotTest7) && back.lots.size() == 7);
		assertTrue(back.removeLot(lotTest6) && back.lots.size() == 6);
		assertTrue(back.removeLot(lotTest5) && back.lots.size() == 5);
		assertTrue(back.removeLot(lotTest4) && back.lots.size() == 4);
	}

	/**
	 * Implemented using JUnit in order to test the getLot() feature implemented by the back-end developers
	 */
	@Test
	void testGetLot() {
		// add the lots
		ParkingBackEnd back = new ParkingBackEnd();
		int[] tempNearby = { 1, 2, 3 };
		ParkingLot lotTest1 = new ParkingLot("123 University Ave.", 4, 50, 25, tempNearby);
		assertTrue(back.addLot(lotTest1) && back.lots.size() == 1);
		ParkingLot lotTest2 = new ParkingLot("987 Langond St.", 10, 500, 125, tempNearby);
		assertTrue(back.addLot(lotTest2) && back.lots.size() == 2);
		int[] tempNearby2 = { 5, 2, 8 };
		ParkingLot lotTest3 = new ParkingLot("384 Mifflin St.", 13, 100, 25, tempNearby2);
		assertTrue(back.addLot(lotTest3) && back.lots.size() == 3);
		ParkingLot lotTest4 = new ParkingLot("592 Johnson St.", 20, 250, 125, tempNearby2);
		assertTrue(back.addLot(lotTest4) && back.lots.size() == 4);
		int[] tempNearby3 = { 1, 2, 3 };
		ParkingLot lotTest5 = new ParkingLot("390 Mifflin St.", 40, 400, 250, tempNearby3);
		assertTrue(back.addLot(lotTest5) && back.lots.size() == 5);
		ParkingLot lotTest6 = new ParkingLot("2034 State St.", 11, 750, 365, tempNearby3);
		assertTrue(back.addLot(lotTest6) && back.lots.size() == 6);
		int[] tempNearby4 = { 5, 2, 8 };
		ParkingLot lotTest7 = new ParkingLot("925 State St.", 16, 75, 25, tempNearby4);
		assertTrue(back.addLot(lotTest7) && back.lots.size() == 7);
		ParkingLot lotTest8 = new ParkingLot("283 Basset St.", 24, 250, 75, tempNearby4);
		assertTrue(back.addLot(lotTest8) && back.lots.size() == 8);
		// test the getLot() by comparing lot numbers
		assertTrue(back.getLot(lotTest1).lotNumber == 4);
		assertTrue(back.getLot(lotTest3).lotNumber == 13);
		assertTrue(back.getLot(lotTest5).lotNumber == 40);
		assertTrue(back.getLot(lotTest7).lotNumber == 16);

	}

	/**
	 * Implemented using JUnit in order to test the sort() feature implemented by the back-end developers
	 */
	@Test
	void testSort() {
		// add the lots
		ParkingBackEnd back = new ParkingBackEnd();
		int[] tempNearby = { 1, 2, 3 };
		ParkingLot lotTest1 = new ParkingLot("123 University Ave.", 4, 50, 25, tempNearby);
		assertTrue(back.addLot(lotTest1) && back.lots.size() == 1);
		ParkingLot lotTest2 = new ParkingLot("987 Langond St.", 10, 500, 125, tempNearby);
		assertTrue(back.addLot(lotTest2) && back.lots.size() == 2);
		int[] tempNearby2 = { 5, 2, 8 };
		ParkingLot lotTest3 = new ParkingLot("384 Mifflin St.", 13, 100, 25, tempNearby2);
		assertTrue(back.addLot(lotTest3) && back.lots.size() == 3);
		ParkingLot lotTest4 = new ParkingLot("592 Johnson St.", 20, 250, 125, tempNearby2);
		assertTrue(back.addLot(lotTest4) && back.lots.size() == 4);
		int[] tempNearby3 = { 1, 2, 3 };
		ParkingLot lotTest5 = new ParkingLot("390 Mifflin St.", 40, 400, 250, tempNearby3);
		assertTrue(back.addLot(lotTest5) && back.lots.size() == 5);
		ParkingLot lotTest6 = new ParkingLot("2034 State St.", 11, 750, 365, tempNearby3);
		assertTrue(back.addLot(lotTest6) && back.lots.size() == 6);
		int[] tempNearby4 = { 5, 2, 8 };
		ParkingLot lotTest7 = new ParkingLot("925 State St.", 16, 75, 25, tempNearby4);
		assertTrue(back.addLot(lotTest7) && back.lots.size() == 7);
		ParkingLot lotTest8 = new ParkingLot("283 Basset St.", 24, 250, 75, tempNearby4);
		assertTrue(back.addLot(lotTest8) && back.lots.size() == 8);
		// test the sort
		assertEquals(back.sort("24").toString(), "[Lot #24: 283 Basset St. (75/250 spots full) (nearby: 5, 2, 8)]");
		assertEquals(back.sort("92").toString(), "[Lot #20: 592 Johnson St. (125/250 spots full) (nearby: 5, 2, 8), Lot #16: 925 State St. (25/75 spots full) (nearby: 5, 2, 8)]");
		assertEquals(back.sort("13").toString(), "[Lot #13: 384 Mifflin St. (25/100 spots full) (nearby: 5, 2, 8)]");
		assertEquals(back.sort("20").toString(), "[Lot #20: 592 Johnson St. (125/250 spots full) (nearby: 5, 2, 8), Lot #11: 2034 State St. (365/750 spots full) (nearby: 1, 2, 3)]");
	}

}

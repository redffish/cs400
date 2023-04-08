// --== CS400 File Header Information ==--
// Name: Lillian Peralta
// Email: lperalta@wisc.edu
// Team: KA
// Role: Front End Developer 2
// TA: Siddarth Mohan
// Lecturer: Florian Heimerl
// Notes to Grader: N/A
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlightApplication extends AirportGraph{
	public static void printHelp() {
		System.out.println(""
				+ "[A] - Add airport or flight\n"
				+ "[R] - Remove airport or flight\n"
				+ "[C] - Search if flight or airport is on map\n"
				+ "[N] - Get the number of airports or flights on map\n"
				+ "[T] - Get the time duration of a flight\n"
				+ "[P] - Get the shortest path of a flight trip\n"
				+ "[H] - Display help menu\n"
				+ "[Q] - Quit application");
		System.out.println("-----------------------------------------------");
	}

	public static void main (String args[]) throws FileNotFoundException {
		AirportGraph map = new AirportGraph();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello! Welcome to the flight application!");
		System.out.println("-----------------------------------------------");
		System.out.println("Would you like to import a pre-made airport map? Enter [1] for yes, [0] for no.");
		int choice;
		if (sc.hasNextInt()) {
			choice = sc.nextInt();
			sc.nextLine();
			// If the command was not the 1 or 0, as stated in the menu, it is unrecognized
			if (choice != 1 && choice != 0) {
				System.out.println("Unrecognized command, defaulting to empty map.");
				System.out.println("-----------------------------------------------");
			}
			else if(choice == 1) {
				System.out.println("What file would you like to add to create map? [Type full path of file]");
				String filename = sc.nextLine();
				Data file = new Data(filename);
				file.loadFile(map);
			}
			else {
				System.out.println("Creating empty map.");
				System.out.println("-----------------------------------------------");
			}
		}
		// If the choice was not an int, the command is unrecognized 
		else {
			sc.nextLine();
			choice = 0;
			System.out.println("Unrecognized command, defaulting to empty map.");
			System.out.println("-----------------------------------------------");
		}

		boolean run = true;
		while(run) {
			printHelp();	
			String command; 
			command = sc.next().toUpperCase();


			switch(command) {
			case "A":
				System.out.println("Would you like to add an airport[1] or a flight[2]?");
				int numA = sc.nextInt();
				if(numA == 1) {
					System.out.println("What is the 3-letter airport code?");
					String code = sc.next().toUpperCase();
					if(!map.insertAirport(code)) {
						System.out.println("The given airport is already on map.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Airport " + code + " added to map.");
						System.out.println("-----------------------------------------------");
						break;
					}
				}
				else if(numA == 2) {
					System.out.println("What is the 3-letter code of the start airport of the flight?");
					String start = sc.next().toUpperCase();
					System.out.println("What is the 3-letter code of the end airport of the flight?");
					String end = sc.next().toUpperCase();
					System.out.println("What is the time duration of this flight in hours?");
					int time = sc.nextInt();
					if(!map.insertFlight(start, end, time)) {
						System.out.println("The given flight is already on map.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Flight from " + start + " to " + end + " added.");
						System.out.println("-----------------------------------------------");
						break;
					}
				}
				else {
					System.out.println("Incorrect input.");
					System.out.println("-----------------------------------------------");
					break;
				}

			case "R":
				System.out.println("Would you like to remove an airport[1] or a flight[2]?");
				int numR = sc.nextInt();
				if(numR == 1) {
					System.out.println("What is the 3-letter airport code?");
					String code = sc.next().toUpperCase();
					if(!map.removeAirport(code)) {
						System.out.println("Airport not found.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Airport " + code + " removed from map.");
						System.out.println("-----------------------------------------------");
					}
				}
				else if(numR == 2) {
					System.out.println("What is the 3-letter code of the start airport of the flight?");
					String start = sc.next().toUpperCase();
					System.out.println("What is the 3-letter code of the end airport of the flight?");
					String end = sc.next().toUpperCase();
					if(!map.removeFlight(start, end)) {
						System.out.println("Flight not found.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Flight from " + start + " to " + end + " removed.");
						System.out.println("-----------------------------------------------");
						break;
					}
				}
				else {
					System.out.println("Incorrect input.");
					System.out.println("-----------------------------------------------");
					break;
				}

			case "C":
				System.out.println("Would you like to search for an airport[1] or a flight[2]?");
				int numC = sc.nextInt();
				if(numC == 1) {
					System.out.println("What is the 3-letter airport code?");
					String code = sc.next().toUpperCase();
					if(!map.containsAirport(code)) {
						System.out.println("Airport not found.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Airport " + code + " is on the map.");
						System.out.println("-----------------------------------------------");
						break;
					}
				}
				else if(numC == 2) {
					System.out.println("What is the 3-letter code of the start airport of the flight?");
					String start = sc.next().toUpperCase();
					System.out.println("What is the 3-letter code of the end airport of the flight?");
					String end = sc.next().toUpperCase();
					if(!map.containsFlight(start, end)) {
						System.out.println("Flight not found.");
						System.out.println("-----------------------------------------------");
						break;
					}
					else {
						System.out.println("Flight from " + start + " to " + end + " is on the map.");
						System.out.println("-----------------------------------------------");
						break;
					}
				}
				else {
					System.out.println("Incorrect input.");
					System.out.println("-----------------------------------------------");
					break;
				}

			case "N":
				System.out.println("Would you like to get the number of airports[1] or flights[2]?");
				int numN = sc.nextInt();
				if(numN == 1) {
					System.out.println("There are " + map.getAirportCount() + " airports on the map.");
					System.out.println("-----------------------------------------------");
					break;
				}
				else if(numN == 2) {
					System.out.println("There are " + map.getFlightCount() + " flights on the map.");
					System.out.println("-----------------------------------------------");
					break;
				}
				else {
					System.out.println("Incorrect input.");
					System.out.println("-----------------------------------------------");
					break;
				}

			case "T":
				System.out.println("What is the 3-letter code of the start airport of the flight?");
				String start = sc.next().toUpperCase();
				System.out.println("What is the 3-letter code of the end airport of the flight?");
				String end = sc.next().toUpperCase();
				System.out.println("The flight from " + start + " to " + end 
						+ " is " + map.getFlightTime(start, end) + " hours.");
				System.out.println("-----------------------------------------------");
				break;

			case "P":
				System.out.println("What is the 3-letter code of the start airport of the flight?");
				String start1 = sc.next().toUpperCase();
				System.out.println("What is the 3-letter code of the end airport of the flight?");
				String end1 = sc.next().toUpperCase();
				String path = map.getShortestPath(start1, end1).toString();
				System.out.println("Shortest path from " + start1 + " to " + end1 + ": " + path);
				System.out.println("-----------------------------------------------");
				break;

			case "H":
				System.out.println("-----------------------------------------------");
				break;

			case "Q":
				System.out.println("Thank you for using the flight application! Goodbye!");
				System.out.println("-----------------------------------------------");
				run = false;
				break;

			default:
				System.out.println("Error: Invalid Command");
				break;

			}
		}
	}	
}


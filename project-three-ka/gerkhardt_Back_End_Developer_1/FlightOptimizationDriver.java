// --== CS400 File Header Information ==--
// Name: Liam Jogal
// Email: ljogal@wisc.edu
// Team: KA
// Role: Front End Developer 1
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A Driver class that lets a user add and remove flights and airports as well
 * as see the best path from one destination to another
 * 
 * @author Liam Jogal, ljogal@wisc.edu
 *
 */
public class FlightOptimizationDriver {

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to fly KA. Would you like to see flights today and or remove flights? (y or n)");
        Scanner scnr = new Scanner(System.in);
        String fly = scnr.nextLine().toUpperCase().trim();
        while (!(fly.equals("Y") || fly.equals("N"))) {
            System.out.println("Please type y or n to indicate if you would like to book flights");
            fly = scnr.nextLine().toLowerCase().trim();
        }
        switch (fly) {
        case "Y":
            start(scnr);
            break;
        default:
            System.out.println("Have a nice day. See you next time");

        }
    }

    private static void retrieveData(Scanner scnr, AirportGraph graph, String input) {

        // Ask to retrieve data
        while (!(input.equals("Y") || input.equals("N"))) {
            System.out.println("Please type y or n to indicate if you would like retrieve data");
            input = scnr.nextLine().toUpperCase().trim();
        }
        switch (input) {
        case "Y":

            boolean check = true;
            while (check) {
                try {
                    DataProcessor retrieve = new DataProcessor();
                    System.out.println("Enter a file to load (flights.csv) suggested");
                    String file = scnr.nextLine().toUpperCase().trim();

                    retrieve.loadFile(graph, file);
                    System.out.println("Data succesfully retrieved");
                    check = false;
                } catch (FileNotFoundException e1) {
                    System.out.println("Unable to recogonize file. Try a different name");
                }
            }
            break;
        default:
            // do nothing
            return;
        }

    }

    private static void start(Scanner scnr) {
        AirportGraph graph = new AirportGraph();
        System.out.println("We appreciate your business. Start by giving us your starting location");
        String begin = scnr.nextLine().toUpperCase().trim();
        graph.insertAirport(begin);

        System.out.println("Would you like to load in flight and airport data(y=yes n=no)");
        String input = scnr.nextLine().toUpperCase().trim();

        retrieveData(scnr, graph, input);
        boolean check = true; // used for commands

        helperCommands();
        String command = scnr.nextLine().toUpperCase().trim();
        while (!(command.toUpperCase().equals("Q"))) {
            switch (command) {
            case "A":
                // Just adding a potential destination
                System.out.println("Would you like to add an airport or a flight, 0 = airport, 1 = flight");
                check = true;
                while (check) {
                    try {
                        input = scnr.nextLine().trim();
                        int num = Integer.parseInt(input);

                        if (num != 0 && num != 1) {
                            System.out.println("Cannot recognize input try again");
                            continue;
                        }
                        check = false;
                        if (num == 0) {
                            System.out.println("Enter a potential destination you would like to add");
                            String add = scnr.nextLine().toUpperCase().trim();
                            graph.insertAirport(add);
                            System.out.println(add + " added");
                        } else {
                            bookFlight(scnr, graph);

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot recognize input try again");
                        continue;
                    }
                }
                break;
            case "R":
                // Just adding a potential destination
                System.out.println("Would you like to remove an airport or a flight, 0 = airport, 1 = flight");
                check = true;
                while (check) {
                    try {
                        input = scnr.nextLine().trim();
                        int num = Integer.parseInt(input);
                        if (num != 0 && num != 1) {
                            System.out.println("Cannot recognize input try again");
                            continue;
                        }
                        check = false;
                        if (num == 0) {
                            System.out.println("Enter a potential destination you would like to add");
                            String remove = scnr.nextLine().toUpperCase().trim();
                            if (!graph.containsAirport(remove)) {
                                System.out.println("Destination never added or removed ealier");
                                break;
                            }
                            graph.removeAirport(remove);
                            System.out.println(remove + " removed");
                        } else {
                            removeFlight(scnr, graph);

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cannot recognize input try again");
                    }
                }

                break;
            case "C":
                System.out.println("Enter a starting airport");
                String check1 = scnr.nextLine().toUpperCase().trim();

                System.out.println("Enter a destination");
                String check2 = scnr.nextLine().toUpperCase().trim();
                if (graph.containsFlight(check1, check2)) {
                    System.out.println("Flight contained");
                } else {
                    System.out.println("Flight not yet added");
                }
                break;
            case "P":
                System.out.println("Enter a starting airport");
                String start = scnr.nextLine().toUpperCase().trim();

                System.out.println("Enter a destination");
                String end = scnr.nextLine().toUpperCase().trim();

                String shortest = null;

                try {
                    shortest = graph.getShortestPath(start, end).toString();
                } catch (NoSuchElementException e) {
                    System.out.println("Path not in graph");
                    break;
                }

                System.out.println("The best route from " + start + " to " + end + " is " + shortest);
                break;
            case "N":
                System.out.println("There are " + graph.getFlightCount() + " flights and " + graph.getAirportCount()
                        + " airports added");
                break;
            case "H":
                helperCommands();
                break;
            default:
                System.out.println("Can't recognize input. Try again");
                break;
            }
            helperCommands();
            command = scnr.nextLine().toUpperCase().trim();
        }
        scnr.close();
        System.out.println("Thank you for your time. Have a great rest of your day!");
    }

    /**
     * Prints out the help menu to display the different commands
     */
    private static void helperCommands() {
        System.out.println("[A]  - Add a flight or airport\r\n" + "[R]  - Remove a flight or airport\r\n"
                + "[C]  - Check if a flight has already been added\r\n"
                + "[P]  - See the best route from one location to another\r\n"
                + "[N]  - Get the count of all flights and airports added\r\n" + "[H]  - Display help menu\r\n"
                + "[Q]  - Quit the application\r\n");
    }

    /**
     * Adds a flight to the AirportGraph. Will add airports in if they have not been
     * added prior.
     * 
     * @param scnr
     * @param graph
     */
    private static void bookFlight(Scanner scnr, AirportGraph graph) {
        System.out.println("Specify a starting location");
        String start = scnr.nextLine().toUpperCase().trim(); // Don't want to be case sensitive

        System.out.println("Specify a destination");
        String end = scnr.nextLine().toUpperCase().trim();

        System.out.println("Specify the time it should take in hours (whole number)");
        String minutes = scnr.nextLine().trim();
        int time = 0;
        boolean check = false;
        // Keep checking until time variable is a valid time
        while (!check) {
            try {
                time = Integer.parseInt(minutes);
                check = true;
            } catch (NumberFormatException e) {
                System.out.println("Specify the time it should take in minutes (whole number)");
            }

        }
        // If any of edges not in graph then no need to check if there is flight
        if (!graph.containsAirport(start) && !graph.containsAirport(end)) {
            graph.forceInsertFlight(start, end, time);
            System.out.println("Flight successfully added!");
            return;
        } else if (!graph.containsAirport(start))
            graph.insertAirport(start);
        else if (!graph.containsAirport(end))
            graph.insertAirport(end);

        // check if theres a flight before inserting
        if (graph.containsFlight(start, end)) {
            System.out.println("Already a flight between start airport and destination");
            return;
        }
        graph.insertFlight(start, end, time);
        System.out.println("Flight successfully added!");

    }

    /**
     * Removes a flight from the airport graph.
     * 
     * @param scnr
     * @param graph
     */
    private static void removeFlight(Scanner scnr, AirportGraph graph) {
        System.out.println("Specify a starting location");
        String start = scnr.nextLine().toUpperCase().trim(); // Dont want to be case sensitive

        System.out.println("Specify a destination");
        String end = scnr.nextLine().toUpperCase().trim();

        if (!(graph.containsAirport(end) || graph.containsAirport(start))) {
            System.out.println("Not a flight so cannot remove");
            return;
        }

        graph.removeFlight(start, end);
        System.out.println("Flight successfully removed");

    }
}
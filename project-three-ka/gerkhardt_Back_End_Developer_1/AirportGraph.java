// --== CS400 File Header Information ==--
// Name: Adam Gerkhardt
// Email: gerkhardt@wisc.edu
// Team: KA
// TA: Sid
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;
import java.util.List;



public class AirportGraph {
  
  
   private CS400Graph<String> airport;
   
   
   public AirportGraph() {
     airport = new CS400Graph<>();
   }
   
   
   /**
   * This is used to create and use the 'edges' in the graph
   *
   */
  public static class Flight {
     public String start;
     public String destination;
     public int time;
     public String toString() {
       return ("Start: " + start + " --> " + destination + ": " + time + " duration");
     }
     
     
     public Flight(String start, String destination, int time) {
       this.start = start;
       this.destination = destination;
       this.time = time;
     }
   }
   
   
   /**
   *  This is used to create and use multiple 'edges' from the base graph
   *
   */
  public static class FlightPath {
     public int totalTime;
     public List<Flight> flights;
     public List<String> airports;
     public String toString() {
       return (String.join(" --> ", airports) + " " + totalTime);
     }
     
     
     public FlightPath(List<Flight> flights, List<String> airports) {
       this.flights = flights;
       this.airports = airports;
       this.totalTime = 0;
       for (Flight flight : flights) {
         this.totalTime += flight.time;
       }
     }
   }
   
   
   /**
    * Insert a new airport into the graph of airports
   * @param code is the three letter representation of the airport
   * @return true if added, false if it couldn't be added due to already existing in the airports
   */
  public boolean insertAirport(String code) {
     return airport.insertVertex(code);
   }
   
   
   /**
    * Remove an airport from the graph of airports
   * @param code is the three letter representation of the airport to be removed
   * @return true if it was remove, false if it couldn't be removed
   */
  public boolean removeAirport(String code) {
     return airport.removeVertex(code);
   }
   
   
   /** Check if the given airport exists in the airport graph
   * @param code is the three letter representation of the airport
   * @return true if the airport graph contains the given airport
   */
  public boolean containsAirport(String code) {
     return airport.containsVertex(code);
   }
   
   
   /** Gets the amount of airports in the graph of airports
   * @return the number of airports in the graph
   */
  public int getAirportCount() {
     return airport.getVertexCount();
   }
   
   
   /**
    *  Insert a new flight path into the airport graph
   * @param start is the starting airport of this flight
   * @param dest is the ending airport of this flight
   * @param time is the time to follow this flight
   * @return true if the flight was added, false if it could not be added
   * due to already having this path in the graph
   */
  public boolean insertFlight(String start, String dest, int time) {
     return airport.insertEdge(start, dest, time);
   }
   
   
   /** Insert a new flight of the given start and end, adding the given airports
    *  to the graph if necessary
   * @param start is the starting airport for the flight
   * @param dest is the ending airport for the flight
   * @param time is the time it takes to fly this flight
   * @return true if flight could be added to the graph, false if it already exists
   */
  public boolean forceInsertFlight(String start, String dest, int time) {
     // First, add these airports if they are not already there
     airport.insertVertex(start);
     airport.insertVertex(dest);
     return airport.insertEdge(start, dest, time);
   }
   
   
   /** Remove a flight from the airport graph
   * @param start is the starting airport of this flight
   * @param dest is the ending airport of this flight
   * @return true if this flight exists and was removed, false if it could not be removed
   */
  public boolean removeFlight(String start, String dest) {
     return airport.removeEdge(start, dest);
   }
   
   
   /** Check if the flight exists
   * @param start the starting airport for this flight to be checked
   * @param end the ending airport for this flight to be checked
   * @return true if this flight exists, false if otherwise
   */
  public boolean containsFlight(String start, String end) {
     return airport.containsEdge(start, end);
   }
   
   
   /** Get the number of flights in the airport graph
   * @return the number of flights
   */
  public int getFlightCount() {
     return airport.getEdgeCount();
   }
   
   
   /** Gets the travel time of a given flight
   * @param start is the starting airport for this flight
   * @param end is the ending airport for this flight
   * @return the travel time of the given flight, if it exists
   */
  public int getFlightTime(String start, String end) {
     return airport.getWeight(start, end);
   }
   
   
   /** This returns the flight path of the shortest flight path
   * @param start is the starting airport of the path
   * @param dest is the ending airport of the path
   * @return the flightpath of the shortest paths
   */
  public FlightPath getShortestPath(String start, String dest) {
     List<String> airports = airport.shortestPath(start, dest);
     List<Flight> flights = new LinkedList<Flight>();
     
     // First check if there are flights in this path
     if (airports.size() > 1) {
       // Loop through and add the airports and their overall weight to the flights list
       for (int i = 0; i < airports.size(); i++) {
         int time = getFlightTime(airports.get(i), airports.get(i + 1));
         flights.add(new Flight(airports.get(i), airports.get(i + 1), time));
       }
     }    
     return new FlightPath(flights, airports);
   }

}

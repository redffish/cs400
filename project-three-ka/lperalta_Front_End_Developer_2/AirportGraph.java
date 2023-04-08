// --== CS400 File Header Information ==--
// Name: Owen Graham
// Email: ohgraham@wisc.edu
// Team: KA
// Role: Back End Developer 2
// TA: Siddarth Mohan
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Tailored interface for an airporty CS400Graph.
 */
public class AirportGraph {

    private CS400Graph<String> graph;

    /**
     * Used to export information about a single edge.
     */
    public static class Flight {
        public String start;
        public String end;
        public int time;
        public String toString() {
            return String.format("%s -> %s (%dh)", start, end, time);
        }
        public Flight(String start, String end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    /**
     * Used to export information about a series of edges.
     */
    public static class FlightPath {
        public int totalTime;
        public List<Flight> flights;
        public List<String> airports;
        public String toString() {
            return String.join(" -> ", airports)
                   + String.format(" (%dh)", totalTime);
        }
        public FlightPath(List<Flight> flights, List<String> airports) {
            this.totalTime = flights.stream().mapToInt((f) -> f.time).sum();
            this.flights = flights;
            this.airports = airports;
        }
    }

    public AirportGraph() {
        graph = new CS400Graph<>();
    }

    /**
     * Insert a new airport into the graph.
     *
     * @param code 3-letter airport code
     * @return whether the airport was not already in the graph
     * @throws NullPointerException if code is null
     */
    public boolean insertAirport(String code) {
        return graph.insertVertex(code);
    }

    /**
     * Remove an airport from the graph.
     *
     * @param code 3-letter airport code
     * @return whether the airport was found and removed
     * @throws NullPointerException if code is null
     */
    public boolean removeAirport(String code) {
        return graph.removeVertex(code);
    }

    /**
     * Check if the given airport is present in the graph.
     *
     * @param code 3-letter airport code
     * @return whether the airport is in the graph
     * @throws NullPointerException if code is null
     */
    public boolean containsAirport(String code) {
        return graph.containsVertex(code);
    }

    /**
     * Count the airports in the graph.
     *
     * @return the number of airports in the graph
     */
    public int getAirportCount() {
        return graph.getVertexCount();
    }

    /**
     * Add a flight from one airport to another.
     *
     * @param start 3-letter origin airport code
     * @param end 3-letter destination airport code
     * @param time integer number of hours the flight takes
     * @return true if the flight could be added, false if there was
     *     already a flight from start to end
     * @throws IllegalArgumentException if either start or end are not
     *     in the graph or if time is nonnegative
     * @throws NullPointerException if start or end is null
     */
    public boolean insertFlight(String start, String end, int time) {
        return graph.insertEdge(start, end, time);
    }

    /**
     * Add a flight from one airport to another. Insert the airports if
     * necessary.
     *
     * @param start 3-letter origin airport code
     * @param end 3-letter destination airport code
     * @param time integer number of hours the flight takes
     * @return true if the flight could be added, false if there was
     *     already a flight from start to end
     * @throws IllegalArgumentException if time is nonnegative
     * @throws NullPointerException if start or end is null
     */
    public boolean forceInsertFlight(String start, String end, int time) {
        graph.insertVertex(start);
        graph.insertVertex(end);
        return graph.insertEdge(start, end, time);
    }

    /**
     * Remove a flight from one airport to another.
     *
     * @param start 3-letter origin airport code
     * @param end 3-letter destination airport code
     * @return whether the flight was found and removed
     * @throws NullPointerException if start or end is null
     */
    public boolean removeFlight(String start, String end) {
        return graph.removeEdge(start, end);
    }

    /**
     * Check if a flight from one airport to another is present in the
     * graph.
     *
     * @param start 3-letter origin airport code
     * @param end 3-letter destination airport code
     * @return whether the flight is in the graph
     * @throws NullPointerException if start or end is null
     */
    public boolean containsFlight(String start, String end) {
        return graph.containsEdge(start, end);
    }

    /**
     * Count the flights in the graph.
     *
     * @return the number of one-way flights in the graph
     */
    public int getFlightCount() {
        return graph.getEdgeCount();
    }

    /**
     * Get the flight time from one airport to another.
     *
     * @param start 3-letter origin airport code
     * @param end 3-letter destination airport code
     * @return the flight time in hours between start and end
     * @throws IllegalArgumentException if either start or end are not
     *     in the graph
     * @throws NullPointerException if start or end is null
     * @throws NoSuchElementException if the flight is not in the graph
     */
    public int getFlightTime(String start, String end) {
        return graph.getWeight(start, end);
    }

    /**
     * Get a FlightPath representation of the shortest path (in hours)
     * between two airports. Includes the total time and a list of
     * individual flights from start to end.
     *
     * @param start 3-letter initial origin airport code
     * @param end 3-letter final destination airport code
     * @return FlightPath of the shortest path from start to end
     * @throws NoSuchElementException if the path cannot be charted
     */
    public FlightPath getShortestPath(String start, String end) {
        List<String> airports = graph.shortestPath(start, end);
        List<Flight> flights = new LinkedList<Flight>();
        // A start-to-start path has no flights.
        // If there are flights to add, do it.
        // [0 -> 1, 1 -> 2, 2 -> 3, ...]
        if (airports.size() > 1) {
            Iterator<String> iterator = airports.iterator();
            String miniStart = iterator.next();
            while (iterator.hasNext()) {
                String miniEnd = iterator.next();
                int time = getFlightTime(miniStart, miniEnd);
                flights.add(new Flight(miniStart, miniEnd, time));
                miniStart = miniEnd;
            }
        }
        return new FlightPath(flights, airports);
    }

}

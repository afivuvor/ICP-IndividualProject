
package ICP_IndividualProject;
/**
 * ICP Individual Project 1
 * @author: Sena A. Vuvor
 *
 * */

import kotlin.jvm.internal.MutablePropertyReference0Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Route {

    /**
     * Declare instance variables of the class
     **/
    public String airline;
    public String airlineID;
    public String destinationAirportCode;
    public int stops;

    public static HashMap<String, ArrayList<Route>> routes = new HashMap<>();
    /**
     * Constructor method for the instance variables
     **/
    public Route(String airlineCode, String airlineID,
                 String destAirportCode, int stops) {
        this.airline = airlineCode;
        this.airlineID = airlineID;
        this.destinationAirportCode = destAirportCode;
        this.stops = stops;
    }

    public String getAirline() {
        return airline;
    }

    public int getStops() {
        return stops;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(String airlineID) {
        this.airlineID = airlineID;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public static HashMap<String, ArrayList<Route>> getRoutes() {
        return routes;
    }

    public static void setRoutes(HashMap<String, ArrayList<Route>> routes) {
        Route.routes = routes;
    }

    /** override toString method for this class */
    @Override
    public String toString() {
        return "Airline= " + airline + " airlineID= " + airlineID + " destinationAirportCode= "
                + destinationAirportCode + " stops= " + stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return stops == route.stops && Objects.equals(airline, route.airline) && Objects.equals(airlineID, route.airlineID) && Objects.equals(destinationAirportCode, route.destinationAirportCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, airlineID, destinationAirportCode, stops);
    }
}
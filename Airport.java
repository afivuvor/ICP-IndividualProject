
package ICP_IndividualProject;
/**
 * ICP Individual Project 1
 * @author: Sena A. Vuvor
 *
 * */
import kotlin.jvm.internal.MutablePropertyReference0Impl;

public class Airport {

    public String airportID;
    public String airportName;
    public String airportCity;
    public String country;
    public String ICAO;

    public Airport(String ID, String name, String city,
                   String country, String ICAO) {
        this.airportID = ID;
        this.airportName = name;
        this.ICAO = ICAO;
    }

    /** override toString method for the class */
    @Override
    public String toString() {
        return airportID + " " + airportName + " " + ICAO;
    }

    /**
     * Main method to compile and run the code
     *
     * */
    public String getAirportID() {
        return airportID;
    }

    public void setAirportID(String airportID) {
        this.airportID = airportID;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getICAO() {
        return ICAO;
    }

    public void setICAO(String ICAO) {
        this.ICAO = ICAO;
    }
}


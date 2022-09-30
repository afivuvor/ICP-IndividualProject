package ICP_IndividualProject;
/**
 * ICP Individual Project 1
 * @author: Sena A. Vuvor
 *
 * */


public class Airline {

    /**
     * Declare instance variables of the class
     **/
    private int airlineID;
    private String airlineName;
    private String alias;
    private String airlineIATA;
    private String airlineICAO;
    private String country;

    /**
     * Constructor method for the instance variables
     * **/
    public Airline(int ID, String name, String alias,
                   String IATA, String ICAO, String country) {
        this.airlineID = ID;
        this.airlineName = name;
        this.alias = alias;
        this.airlineIATA = IATA;
        this.airlineICAO = ICAO;
        this.country = country;
    }

    /**
     * Accessor and mutator methods for instance variables
     * */
    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAirlineIATA() {
        return airlineIATA;
    }

    public void setAirlineIATA(String airlineIATA) {
        this.airlineIATA = airlineIATA;
    }

    public String getAirlineICAO() {
        return airlineICAO;
    }

    public void setAirlineICAO(String airlineICAO) {
        this.airlineICAO = airlineICAO;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}

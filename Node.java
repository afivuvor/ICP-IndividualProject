package ICP_IndividualProject;
/**
 * ICP Individual Project 1
 * @author: Sena A. Vuvor
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Node {

    public Node parentNode;
    public String airportCode;
    public int stops;
    public String airlineCode;
    public ArrayList<Route> successors;

    public Node (Node parent, String code, int stops, String airlineCode, ArrayList<Route> successors) {
        this.parentNode = parent;
        this.airportCode = code;
        this.stops = stops;
        this.airlineCode = airlineCode;
        this.successors = successors;
    }

    @Override
    public String toString() {
        String str = "Node with airport code " + airportCode
                + " stops= " + stops;
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return stops == node.stops && Objects.equals(parentNode, node.parentNode)
                && Objects.equals(airportCode, node.airportCode) && Objects.equals(airlineCode, node.airlineCode)
                && Objects.equals(successors, node.successors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentNode, airportCode, stops, airlineCode, successors);
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public ArrayList<Route> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<Route> successors) {
        this.successors = successors;
    }

    /**
     * @method: solution_path()
     * @param: None
     * @return type: ArrayList
     * */
    public ArrayList<String> solution_path() {
        ArrayList<String> airlineCodeList = new ArrayList<>();
        ArrayList<String> airportCodeList = new ArrayList<>();
        ArrayList<Integer> stopsList = new ArrayList<>();
        ArrayList<String> solnPath = new ArrayList<>();
        Node currentNode = this;

        while (currentNode != null) {
            airlineCodeList.add(currentNode.getAirlineCode());
            airportCodeList.add(currentNode.getAirportCode());
            stopsList.add(currentNode.getStops());
            currentNode = currentNode.parentNode;
        }
        Collections.reverse(airlineCodeList);
        Collections.reverse(airportCodeList);

        for (int j = 0; j < airlineCodeList.size()-1; j++) {
            String output = airlineCodeList.get(j + 1) + " from " + airportCodeList.get(j)
                    + " to " + airportCodeList.get(j + 1) + " " + stops + " stops.";
            solnPath.add(output);
        }

        return solnPath;
    }

}

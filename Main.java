package ICP_IndividualProject;

/**
 * ICP Individual Project 1
 * @author: Sena A. Vuvor
 * */

import java.io.*;
import java.util.*;

public class Main {
    /* Map of airports to all possible routes that go from it */
    static HashMap<String, ArrayList<Route>> routes = new HashMap<>();
    /* Map of airport codes to String(city, country) */
    static HashMap<String, String> airports = new HashMap<>();
    /* Map of String(city, country) to airport codes */
    static HashMap<String, ArrayList<String>> locationToAirportsMap = new HashMap<String, ArrayList<String>>();

    /**
     * Method to read data from routes.csv file
     * @method: readFile()
     * @param: None
     * @return: void
     */
    public static void readFile() {

        /**
         * Read and process routes.csv file
         * */

        BufferedReader fileReader = null;

        try {
            String row = "";
            fileReader = new BufferedReader(new FileReader("C:/Users/HP/OneDrive - Ashesi " +
                    "University/Desktop/Year2_Sem2/Intermediate C. Programming/routes.csv"));

            while ((row = fileReader.readLine()) != null) {
                String[] routeEntries = row.split(",");

                String key = routeEntries[2];

                Route route = new Route(routeEntries[0], routeEntries[1],
                        routeEntries[4], Integer.parseInt(routeEntries[7]));

                ArrayList<Route> values = routes.get(key); /* Get the corresponding values for each key */

                /*
                 * If values is null, key does not have any value yet. Create new
                 * values arraylist for the key and add current value to it.
                 */
                if (values == null) {
                    ArrayList<Route> newValues = new ArrayList<>();
                    newValues.add(route);
                    routes.put(key, newValues);

                /*
                 * If values is not null, check if current route is not in values before adding,
                 * to prevent duplicate routes in each value arraylist
                 */
                } else if (values != null) {
                    if (!values.contains(route)) {
                        values.add(route);
                        routes.put(key, values);
                    }
                }
            }
//            routes.forEach((key, value) -> System.out.println(key + " " + value));
            fileReader.close();

        /* Catch FileNotFoundException and IOExceptions */
        } catch (FileNotFoundException fnfe) {System.out.println(fnfe.getMessage());

        } catch (IOException ioe) {System.out.println(ioe.getMessage());}


        /**
         * Read and process airports.csv file
         */

        BufferedReader airportFileReader = null;

        try {
            String row = "";
            airportFileReader = new BufferedReader(new FileReader("C:/Users/HP/OneDrive - Ashesi " +
                    "University/Desktop/Year2_Sem2/Intermediate C. Programming/airports.csv"));

            while ((row = airportFileReader.readLine()) != null) {
                String[] airportEntries = row.split(",");

                String values = airportEntries[2] + ", " + airportEntries[3];
                airports.put(airportEntries[4], values);

                /* Create new arraylist of airport codes and store them as airportValues */
                ArrayList<String> airportValues = locationToAirportsMap.get(values);

                /*
                 * If airportValues is null, the String(city, country) key does not have any value yet.
                 * Create new airport values arraylist for the key and add corresponding airport code to it.
                 */
                if (airportValues == null) {
                    ArrayList<String> newAirportValues = new ArrayList<>();
                    String codeforAirport = airportEntries[4];
                    String nullValue = "\\N";
                    if (!codeforAirport.equals(nullValue)) {
                        newAirportValues.add(airportEntries[4]);
                    } else {
                        newAirportValues.add(airportEntries[5]);
                    }
                    locationToAirportsMap.put(values, newAirportValues);

                /*
                 * If airportValues is not null, check if current route is in values before
                 * adding, to prevent duplicate airport codes in each value arraylist
                 */
                } else if (airportValues != null) {
                    if (!airportValues.contains(airportEntries[4])) {
                        String codeForAirport = airportEntries[4];
                        airportValues.add(codeForAirport);
                        locationToAirportsMap.put(values, airportValues);
                    }
                }

            }

            airportFileReader.close();
            /** Catch FileNotFoundException and IOExceptions */
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * @method: bfs
     * @param: String src -- source city
     * @param: String dest -- destination city
     * @return: ArrayList<String> of flights from source city to destination city
     * Based on understanding from Dr.Ayorkor Korsah's bfs algorithm
     */
    public static ArrayList<String> bfs(String src, String dest) {
        /* Create the frontier and explored sets */
        Queue<Node> frontier = new ArrayDeque<>(); /* frontier */
        Set<String> explored = new HashSet<String>(); /* Explored Set */
        ArrayList<String> fetchAirports = locationToAirportsMap.get(src);

        if (fetchAirports != null) {
            for (String airportCode : fetchAirports) {
                frontier.add(new Node(null, airportCode, 0, null, null));
            }
        } else {System.out.println("Sorry, the source location has no airports!");}

        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            explored.add(node.getAirportCode());
            ArrayList<Route> successors = routes.get(node.getAirportCode());
            if (successors != null) {
                for (Route successor : successors) {
                    Node child = new Node(node, successor.getDestinationAirportCode(),
                            successor.getStops(), successor.getAirline(), null);
                    String destination = airports.get(child.getAirportCode());

                    if (!frontier.contains(child) && !explored.contains(child.getAirportCode())) {
                        if (destination != null && destination.equals(dest)) {
                            return child.solution_path();
                        }
                    }
                    frontier.add(child);
                }
            } else {System.out.println("The airport for your source city has no corresponding routes.");}
        }
        System.out.println("Destination not found with bfs!");
        return null;
    }


    /**
     * @method: main
     * @param: String[] args
     * @return: void
     */
    public static void main(String[] args) {
        Main.readFile();

        /** Read input from input text file */
        BufferedReader inputReader = null;
        try {
            String thisrow = "";
            String inputFilePath = "src/ICP_IndividualProject/antwerp-lagos.txt";
            inputReader = new BufferedReader(new FileReader(inputFilePath));

            String inputLocation = inputReader.readLine();
            String inputDestination = inputReader.readLine();

            ArrayList<String> output = bfs(inputLocation, inputDestination);
            if (output == null) {
                System.out.println("Sigh. Bfs found no flights from your source to your destination.");
            } else {
                /* Create filepath for output file */
                int outputIndex = inputFilePath.indexOf(".txt");
                String insert = "_output";
                StringBuffer outputFilePath = new StringBuffer(inputFilePath);
                outputFilePath.insert(outputIndex, insert);

                /* Create new output file using filepath created above */
                File newFile = new File(String.valueOf(outputFilePath));
                FileOutputStream outputStream = new FileOutputStream(newFile);
                BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(outputStream));
                int flightCount = 0;

                /* for each line in output of flights, insert line into output file */
                for (String element : output) {
                    System.out.println(element);
                    outputFile.write(element);
                    flightCount += 1;
                    outputFile.newLine();
                }
                outputFile.write("Total flights: " + flightCount + ".");
                outputFile.close();
            }

        /** Catch FileNotFoundException and IOExceptions */
        } catch (FileNotFoundException fnfe) {System.out.println(fnfe.getMessage());

        } catch (IOException e) {System.out.println(e.getMessage());

        }

    }
}

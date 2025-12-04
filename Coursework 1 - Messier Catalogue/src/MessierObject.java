import java.util.ArrayList;
import java.util.List;

public class MessierObject implements Comparable<MessierObject> {
    private String messierNum;
    private String ngcIcNum;
    private String commonName;
    private String type;
    private String distance;
    private String constellation;
    private String apparentMag;
    private double rightAsc;
    private double dec;

    //constructor
    public MessierObject(String messierNum, String ngcIcNum, String commonName,
                         String type, String distance, String constellation,
                         String apparentMag, double rightAsc, double dec) {

        this.messierNum = messierNum;
        this.ngcIcNum = ngcIcNum;
        this.commonName = commonName;
        this.type = type;
        this.distance = distance;
        this.constellation = constellation;
        this.apparentMag = apparentMag;
        this.rightAsc = rightAsc;
        this.dec = dec;
    }


    //for calculating RA
    private static double parseRA(String RA) {
        //replacing letters with spaces, so they can be split type shi
        String cleaned = RA.replace("h", " ")
                .replace("m", " ")
                .replace("s", " ")
                .trim();

        String[] parts = cleaned.split("\\s+");

        double hours = Double.parseDouble(parts[0]);
        double minutes = Double.parseDouble(parts[1]);
        double seconds = Double.parseDouble(parts[2]);

        //converting into decimal hours
        double decimalHours = hours + (minutes / 60.0) + (seconds / 3600.0);
        //convert hours  ->  degrees  ->  radians
        double degrees = decimalHours *15.0;

        return Math.toRadians(degrees);
    }

    //for calculating declination
    private static double parseDec(String decStr) {

        decStr = decStr.trim();

        // Check if declination is negative
        int sign = 1;
        if (decStr.startsWith("-")) {
            sign = -1;
            decStr = decStr.substring(1).trim();  // remove the '-' if there for easier parsing
        }

        //replace the symbols for easier splitting
        decStr = decStr.replace("°", " ")
                .replace("'", " ")
                .replace("\"", " ")
                .trim();

        String[] parts = decStr.split("\\s+");

        //converts string to doubles
        double degrees = Double.parseDouble(parts[0]);
        double minutes = Double.parseDouble(parts[1]);
        double seconds = Double.parseDouble(parts[2]);

        //convertin to decimal degrees
        double decimal = degrees + (minutes / 60.0) + (seconds / 3600.0);

        // Apply sign IF num is negative
        decimal = decimal * sign;

        // converting to angle in radians
        return Math.toRadians(decimal);
    }


    //new parsing method - ignores commas inside quotes
    private static String[] parseLine(String line) {
        List<String> fields = new ArrayList<>(); //stores resulting fields
        StringBuilder current = new StringBuilder(); //used to build 1 field as file is scanner
        boolean insideQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') { //checks for quote marks to enable state to ignore commas inside quotes
                insideQuotes = !insideQuotes;
            }
            else if (c == ',' && !insideQuotes) {  //if there is a comma, and this comma is not inside quotes
                //splits the field below, adds to list
                fields.add(current.toString().trim().replace("\"", ""));
                current.setLength(0); //resets string builder for next field
            }
            else {
                current.append(c); //otherwise, add the letter to current field
            }
        }

        // last field must be done manually
        fields.add(current.toString().trim().replace("\"", ""));

        return fields.toArray(new String[0]);
    }


    public MessierObject(String line) {
        String[] parts = parseLine(line); //Parses and cleans line into separate fields


        // DEBUG PRINTS - temporary
        //System.out.println("RAW line (pre-conversion): " + line);


        this.messierNum = parts[0];
        this.ngcIcNum = parts[1];
        this.commonName = parts[2];
        this.type = parts[3];
        this.distance = parts[4];
        this.constellation = parts[5];
        this.apparentMag = parts[6];
        this.rightAsc = parseRA(parts[7]); //calculates RA
        this.dec = 0.0;
    }


    //Accessor methods
    public String getMessierNum() {return messierNum;}
    public String getNgcIcNum() {return ngcIcNum;}
    public String getCommonName() {return commonName;}
    public String getType() {return type;}
    public String getDistance() {return distance;}
    public String getConstellation() {return constellation;}
    public String getApparentMag() {return apparentMag;}
    public double getRightAsc() {return rightAsc;}
    public double getDec() {return dec;}

    private double parseMag(String mag) {
        mag = mag.trim(); //Converts mag string into a value

        //Handling the ranges
        if (mag.contains("-")) { //Checks if it is a range
            return Double.parseDouble(mag.split("-")[0].trim()); //Converts first number to double
        }
        return Double.parseDouble(mag);
    }

    //Comparable
    @Override
    public int compareTo(MessierObject other) {

        double m1 = parseMag(this.apparentMag);
        double m2 = parseMag(other.apparentMag);
        return Double.compare(m1, m2); //Comparing the object magnitudes
    }

    //toString
    @Override
    public String toString() {
        return messierNum + "," +
                ngcIcNum + "," +
                commonName + "," +
                type + "," +
                distance + "," +
                constellation + "," +
                apparentMag + "," +
                rightAsc + "," +
                dec;
    }

}
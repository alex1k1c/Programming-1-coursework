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


    private static String[] parseLine(String line) {
        String[] p = line.split(","); // splits the line into parts separated by commas

        String[] cleaned = new String[p.length];

        for (int i = 0; i <  p.length; i++) {
            cleaned[i] = p[i].trim().replace("\"", ""); //removes double quotes from parts
        }

        return cleaned; // new clean list of info
    }
    //constructor 2 - takes 1 whole line as parameter from text file
    /*public MessierObject(String line) {
        //String[] p = line.split(",");
        //this function is needed, as you cannot put any code above 'this' - must be at top of constructor
        //therefore function goes inside the 'this' statement
        this(
                parseLine(line)[0],
                parseLine(line)[1],
                parseLine(line)[2],
                parseLine(line)[3],
                parseLine(line)[4],
                parseLine(line)[5],
                parseLine(line)[6],
                0.0, //temporary
                0.0);//temporary
    }*/
    public MessierObject(String line) {
        String[] parts = parseLine(line); //Parses and cleans line into separate fields
        this.messierNum = parts[0];
        this.ngcIcNum = parts[1];
        this.commonName = parts[2];
        this.type = parts[3];
        this.distance = parts[4];
        this.constellation = parts[5];
        this.apparentMag = parts[6];
        this.rightAsc = 0.0;
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
        return Double.compare(m1, m2); //Comparing the object mags
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
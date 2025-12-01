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
        String[] p = line.split(","); // splits the line into parts seperated by commas

        String[] cleaned = new String[8];

        for (int i = 0; i < 8; i++) {
            cleaned[i] = p[i].trim().replace("\"", ""); //removes double quotes from parts
        }

        return cleaned; // new clean list of info
    }
    //constructor 2 - takes 1 whole line as parameter from text file
    public MessierObject(String line) {
        //String[] p = line.split(",");
        //this function is needed, as you cannot put any code above 'this' - must be at top of constructo
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

    //Comparable
    @Override
    public int compareTo(MessierObject other) {
        return
    }

}
public class MessierObject {
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

    //Getters
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


}
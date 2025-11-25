public class MessierObject {
    private String messierNum;
    private String ncgNum;
    private String commonName;
    private String type;
    private String distance;
    private String constellation;
    private String apparentMag;
    private double rightAsc;
    private double dec;

    //constructor
    public MessierObject(String messierNum, String ncgNum, String commonName,
                         String type, String distance, String constellation,
                         String apparentMag, double rightAsc, double dec) {
    }




    public static void main(String[] args) {
        //testing instance creation
        MessierObject test = new MessierObject("M1", "NGC 1952");
        MessierObject test2 = new MessierObject("M2", "NGC 7089");

        System.out.println("the first object is called "+test.messierNum + ". the ncg number is "+ test.ncgNum);
        System.out.println("the next object is called "+test2.messierNum + ". the ncg number is "+ test2.ncgNum);
    }
}
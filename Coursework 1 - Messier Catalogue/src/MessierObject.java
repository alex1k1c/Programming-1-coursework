public class MessierObject {
    String messierNum;
    String ncgNum;
    //constructor
    public MessierObject(String m, String n) {
        messierNum = m;
        ncgNum = n;
    }




    public static void main(String[] args) {
        //testing instance creation
        MessierObject test = new MessierObject("M1", "NGC 1952");
        MessierObject test2 = new MessierObject("M2", "NGC 7089");

        System.out.println("the first object is called "+test.messierNum + ". the ncg number is "+ test.ncgNum);
        System.out.println("the next object is called "+test2.messierNum + ". the ncg number is "+ test2.ncgNum);
    }
}
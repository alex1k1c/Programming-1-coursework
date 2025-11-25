public class MessierObject {
    String messierNum;
    //constructor
    public MessierObject(String m) {
        messierNum = m;
    }




    public static void main(String[] args) {
        //testing instance creation
        MessierObject test = new MessierObject("M1");

        System.out.println("the first object is called "+test.messierNum);
    }
}
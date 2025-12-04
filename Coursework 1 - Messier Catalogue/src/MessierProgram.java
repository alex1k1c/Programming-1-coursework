import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


public class MessierProgram {
    public static void main(String[] args) {
        MessierCatalogue catalogue = new MessierCatalogue();
        catalogue.loadCatalogue("src/messier.txt");

        List<MessierObject> list = catalogue.getMember(); //Retrieving list of MessierObject from catalogue

        //(a)
        System.out.println("Lexicographical order by constellation:");

        List<MessierObject> sortedList = new ArrayList<>(list); //New list so original list is not changed
        sortedList.sort(new Comparator<MessierObject>() { //Sorting list based on constellation
            @Override
            public int compare(MessierObject o1, MessierObject o2) {
                //Comparing two MessierObjects by constellation
                return o1.getConstellation().compareTo(o2.getConstellation());
            }
        });
        //Loops through the sorted list printing each object
        for (MessierObject obj : sortedList){
            System.out.println(obj);
        }
        System.out.println();
    }
}

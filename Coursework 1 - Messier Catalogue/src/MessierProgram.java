import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Objects;


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


        //(b)
        System.out.println("(B)");
        System.out.println("This is the average apparent magnitude for all globular clusters.");
        double avgMagnitude = 0;
        double sum = 0; //
        int count = 0;
        for (MessierObject o : catalogue.getMember()) {
            if (Objects.equals(o.getType(), "Globular cluster")) { //checking if the type is right

                //if the type is right, magnitude is added to sum, count is recorded to divide both by eachother
                double i = Double.parseDouble(o.getApparentMag());
                sum += i;
                count+= 1;
                avgMagnitude = (sum/count);

            }


        }
        System.out.println("The average magnitude for all globular clusters is: "+ avgMagnitude);

        System.out.println();

        //c


        //d
        System.out.println("(D): ");
        System.out.println("Here are details of the object in constellation Sagittarius with the highest declination: ");


        MessierObject highest = null;

        for (MessierObject o : catalogue.getMember()) {
            if (Objects.equals(o.getConstellation(), "Sagittarius")) { //check if the object's constellation matches "Sagittarius"

                /*checking if:
                 - number is either first in the list
                 - or declination is greater than the highest number so far*/
                if (highest == null ||  o.getDec() > highest.getDec()) {
                    highest = o;

                }
            }
        }
        System.out.println(highest);
    }






}

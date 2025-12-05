import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Objects;

public class MessierProgram {
    public static void main(String[] args) {
        MessierCatalogue catalogue = new MessierCatalogue();
        catalogue.loadCatalogue("messier.txt");

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
        for (MessierObject obj : sortedList) {
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

                //if the type is right, magnitude is added to sum, count is recorded to divide both by each other
                double i = Double.parseDouble(o.getApparentMag());
                sum += i;
                count += 1;
                avgMagnitude = (sum / count);

            }


        }
        System.out.println("The average magnitude for all globular clusters is: " + avgMagnitude);
        System.out.println();

        //c
        System.out.println("Least distant open cluster");

        MessierObject closestOpen = null; //Stores closest open cluster when found
        double minDistance = Double.MAX_VALUE; //Starting with the largest value so any real distance is smaller
        //Loop through every MessierObject in list
        for (MessierObject obj : list) {
            if (obj.getType().toLowerCase().contains("open")) { //Checks if object is an open cluster
                try {
                    double dist = Double.parseDouble(obj.getDistance());
                    //If distance is smaller than previous min distance, value is updated
                    if (dist < minDistance) {
                        minDistance = dist;
                        closestOpen = obj;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        //When loop finishes result is printed
        if (closestOpen != null) {
            System.out.println("The least distant open cluster is:");
            System.out.println(closestOpen);
        }
        System.out.println();


        //(d)
        System.out.println("(D) ");
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

        System.out.println();



        //(e)
        System.out.println("(E) ");

        //find M45
        MessierObject target = null;
        for (MessierObject o : catalogue.getMember()) {
            if (o.getMessierNum().equals("M45")){
                target = o; //target spotted
                break;
            }
        }
        if (target == null) {
            System.out.println("Target not found.");
            return;
        }

        // variable declaration
        MessierObject closest = null;
        double smallest = Double.MAX_VALUE;

// compares every object with m45
        for (MessierObject o : catalogue.getMember()) {

            // avoids comparing itself
            if (o == target) continue;

            double angDist = angularDistance(target, o); //calls method to calculate distance

            //if the angular distance found is the smallest yet, set it as the closest obj
            if (angDist < smallest) {
                smallest = angDist;
                closest = o;
            }
        }

    // output the distance
        System.out.println("The object closest in the sky to M45 is:");
        System.out.println(closest);

        double arcmin = smallest * (180.0 / Math.PI) * 60.0; //converts from radians to arcminutes

        System.out.println("Angular separation (In arcminutes): " + arcmin);

    }




    //<----Methods below---->

    // calculating angular distance between two MessierObjects.
    // takes in RA and DEC as radians
    private static double angularDistance(MessierObject a, MessierObject b) {
        double ra1 = a.getRightAsc();
        double dec1 = a.getDec();
        double ra2 = b.getRightAsc();
        double dec2 = b.getDec();

        double cosD = Math.sin(dec1) * Math.sin(dec2)
                + Math.cos(dec1) * Math.cos(dec2) * Math.cos(ra1 - ra2);

        return Math.acos(cosD);  // returns distance in radians
    }
}

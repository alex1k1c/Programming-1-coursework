import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MessierCatalogue {
    //public void make Me
    private List<MessierObject> member = new ArrayList<>(); //This is the list that contains all the messier objects

    public void loadCatalogue(String filename) {
        File data = new File(filename); //grabs all messier data from text file
        //try
        try (Scanner reader = new Scanner(data)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine(); //reads the next line of content

                MessierObject obj = new MessierObject(line); //creates a messierobject from the line
                member.add(obj); //adds object to list
                //System.out.println(line);
                //System.out.println(obj.getMessierNum());
            }
        } catch (FileNotFoundException e) {//error check if file isnt found
            System.out.println("Error: file cannot be found.");
            //e.printStackTrace();// helps diagnose exceptions
        }



    }
    public static void main (String[]args){
        MessierCatalogue mc = new MessierCatalogue();

        mc.loadCatalogue("messier.txt");
        //System.out.println(mc.catalogue);
        for (MessierObject o : mc.member){
            System.out.println(o); //prints everything
        }


    }
}


/*steps this needs to have
Load every line from messier.txt
- open file
- read 1 line at a time
- pass the line into messierObject constructor
- add that object into list and close file
Turn each line into a messierObject
Store these objects in a collection
provide methods for queries

 */
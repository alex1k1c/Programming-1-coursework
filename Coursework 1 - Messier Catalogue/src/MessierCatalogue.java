import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MessierCatalogue {
    //
    private List<MessierObject> member = new ArrayList<>(); //This is the list that contains all the messier objects

    public List<MessierObject> getMember() {
        return member; //Allows other classes to access Messier Objects
    }
    public void loadCatalogue(String filename) {
        File data = new File(filename); //grabs all messier data from text file
        //try
        try (Scanner reader = new Scanner(data)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine(); //reads the next line of content
                MessierObject obj = new MessierObject(line); //creates a messierobject from the line
                member.add(obj); //adds object to list

            }
        } catch (FileNotFoundException e) {//error check if file isnt found
            System.out.println("Error: file cannot be found.");
            //e.printStackTrace();// helps diagnose exceptions
        }



    }

}



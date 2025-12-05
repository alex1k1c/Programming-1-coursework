import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MessierCatalogue {
    //
    private List<MessierObject> member = new ArrayList<>(); //This is the list that contains all the messier objects

    public List<MessierObject> getMember() {
        return member; //return the list of MessierObjects stored in catalogue
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

        }



    }
    //tostring to print entire catalogue
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MessierObject obj : member) {
            sb.append(obj.toString()).append("\n");
        }
        return sb.toString();
    }

// main method temporarily back for testing
    public static void main(String[] args) {
        MessierCatalogue catalogue = new MessierCatalogue();
        catalogue.loadCatalogue("src/messier.txt");
        System.out.println(catalogue);
    }
}



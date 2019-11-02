import java.io.IOException;

public class Application {

    public static void main (String [ ] args){

        System.out.println("----------Duplicate Counter Application----------\n");

        try {
            DuplicateCounter duplicateCounter = new DuplicateCounter();

            duplicateCounter.count("problem2.txt");
            duplicateCounter.write("unique_word_counts.txt");

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Goodbye!");
    }
}

import java.io.IOException;

public class Application {

    public static void main (String [ ] args){

        System.out.println("----------- Duplicate Word Remover -----------\n");

        try {
            DuplicateRemover duplicateRemover = new DuplicateRemover();

            duplicateRemover.remove("problem1.txt");
            duplicateRemover.write("unique_words.txt");

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
            System.out.println("\nGoodbye!");
    }
}

import java.io.*;
import java.util.ArrayList;

public class DuplicateRemover {

    ArrayList<String> uniqueWords = new ArrayList<String>();
    boolean fileRead = false;

    public void remove(String dataFile) throws IOException {

        try (FileReader readFile = new FileReader(dataFile);
             BufferedReader removeBuffer = new BufferedReader(readFile)){

            String readLine = removeBuffer.readLine();

            while (readLine != null) {

                String word[] = readLine.split(" ");

                for (String i : word){
                    if (!uniqueWords.contains(i)){
                        uniqueWords.add(i);
                    }
                }
                readLine = removeBuffer.readLine();
            }

            System.out.println("The file " + dataFile + " has been successfully opened.");
            fileRead = true;

        }catch (IOException e){
            fileRead = false;
            System.out.println("Error: " + e.getMessage());
        }
    }
//----------------------------------------------------------------------------
    public void write(String outputFile) throws IOException {

        if(!fileRead){
            return;
        }

        try (PrintWriter write = new PrintWriter(outputFile)){
            for (String i : uniqueWords){
                write.println(i);
            }
            System.out.println("The file " + outputFile + " has been successfully created.");

        }catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
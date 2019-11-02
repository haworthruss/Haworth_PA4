import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {

    Map<String, Integer> wordCounter = new HashMap<String, Integer>();
    boolean fileRead = false;

        public void count(String dataFile) throws IOException {

            try (FileReader readFile = new FileReader(dataFile);
                 BufferedReader reader = new BufferedReader(readFile)){

                String readLine = reader.readLine();

                System.out.println("The file " + dataFile + " has been successfully opened.");

                while (readLine != null) {

                    String temp[] = readLine.split(" ");

                    for (String i : temp) {

                        if (!wordCounter.containsKey(i)) {
                            wordCounter.put(i, 1);
                        } else {
                            int count = wordCounter.get(i);
                            wordCounter.put(i, count + 1);
                        }
                    }
                    readLine = reader.readLine();
                }
                fileRead = true;
            }catch (IOException e) {
                fileRead = false;
                System.out.println("Error: " + e.getMessage());
            }

        }

//--------------------------------------------------------------------------------------
    public void write(String outputFile) throws IOException {

        if (!fileRead){
            return;
        }

        try (PrintWriter write = new PrintWriter(outputFile)){

            for (Map.Entry<String, Integer> entry : wordCounter.entrySet()){
                write.println(entry.getKey() + " : " + entry.getValue());
            }

            System.out.println("The file " + outputFile + " has been successfully created.");

        }catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private Set<String> uniqueWords;

    public void remove(String dataFile) throws FileNotFoundException {
        Scanner scnr = new Scanner(new File(dataFile));
        uniqueWords = new HashSet<String>();
        String word;

        while (scnr.hasNext()) {
            word = scnr.next();
            uniqueWords.add(word);
        }

        scnr.close();
    }

    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);
        FileWriter fw;

        if (file.exists()) {
            fw = new FileWriter(file);
            for (String word : uniqueWords) {
                fw.write(word + "\n");
            }
            fw.close();
        }
        else {
            file.createNewFile();
            fw = new FileWriter(file);
            for (String word : uniqueWords) {
                fw.write(word + "\n");
            }
            fw.close();
        }
    }
}

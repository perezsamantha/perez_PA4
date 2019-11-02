import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public void count(String dataFile) throws FileNotFoundException {
        wordCounter = new HashMap<String, Integer>();

        Scanner scnr = new Scanner(new File(dataFile));
        String word;

        while (scnr.hasNext()) {
            word = scnr.next();
            if (!wordCounter.containsKey(word)) {
                wordCounter.put(word, 1);
            }
            else {
                wordCounter.put(word, wordCounter.get(word) + 1);
            }
        }

        scnr.close();
    }

    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);
        PrintWriter pw;

        if (!file.exists()) {
            file.createNewFile();
        }

        pw = new PrintWriter(file);
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet()) {
            pw.println(entry.getKey() + " " + entry.getValue());
        }
        pw.close();
    }
}

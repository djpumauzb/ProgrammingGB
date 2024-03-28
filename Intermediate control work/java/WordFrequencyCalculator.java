import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCalculator {
    private String filePath;

    public WordFrequencyCalculator(String filePath) {
        this.filePath = filePath;
    }

    public void calculateWordFrequency() {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            Map<String, Integer> frequencies = new HashMap<>();
            while (scanner.hasNext()) {
                String word = scanner.next();
                frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
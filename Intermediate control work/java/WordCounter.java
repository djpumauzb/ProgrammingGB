import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    private String filePath;

    public WordCounter(String filePath) {
        this.filePath = filePath;
    }

    public void countWords() {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println("Total words: " + count);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

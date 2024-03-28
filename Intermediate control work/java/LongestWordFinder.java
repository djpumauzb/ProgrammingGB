import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestWordFinder {
    private String filePath;

    public LongestWordFinder(String filePath) {
        this.filePath = filePath;
    }

    public void findLongestWord() {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            String longestWord = "";
            while (scanner.hasNext()) {
                String currentWord = scanner.next();
                if (currentWord.length() > longestWord.length()) {
                    longestWord = currentWord;
                }
            }
            System.out.println("Longest word: " + longestWord);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
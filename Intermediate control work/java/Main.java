public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";

        WordCounter wordCounter = new WordCounter(filePath);
        wordCounter.countWords();

        LongestWordFinder longestWordFinder = new LongestWordFinder(filePath);
        longestWordFinder.findLongestWord();

        WordFrequencyCalculator wordFrequencyCalculator = new WordFrequencyCalculator(filePath);
        wordFrequencyCalculator.calculateWordFrequency();
    }
}
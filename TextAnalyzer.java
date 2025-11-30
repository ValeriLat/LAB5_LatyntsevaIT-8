//5
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
    public static void analyzeText(String filename) {
        Set<Character> deafConsonants = Set.of('п', 'ф', 'к', 'т', 'ш', 'с', 'х', 'ц', 'ч', 'щ');

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder textBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                textBuilder.append(line).append(" ");
            }

            String text = textBuilder.toString();
            String[] words = text.toLowerCase().split("[^а-яё]+");

            List<String> oddWords = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if ((i + 1) % 2 == 1 && !words[i].isEmpty()) {
                    oddWords.add(words[i]);
                }
            }

            Set<Character> result = new TreeSet<>(deafConsonants);

            for (String word : oddWords) {
                Set<Character> wordDeafConsonants = new HashSet<>();
                for (char c : word.toCharArray()) {
                    if (deafConsonants.contains(c)) {
                        wordDeafConsonants.add(c);
                    }
                }
                result.retainAll(wordDeafConsonants);
            }

            System.out.println("Глухие согласные в каждом нечетном слове: " + result);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileAnalyzer {

    public static void main(String[] args) {
        String filename = "input.txt";
        analyzeFile(filename);
    }

    public static void analyzeFile(String filename) {
        int wordCount = 0;
        String longestWord = "";
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            // Чтение файла и анализ
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(); // Чтение слова и перевод в нижний регистр

                // Увеличение счетчика слов
                wordCount++;

                // Проверка на самое длинное слово
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }

                // Подсчет частоты слов
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            // Вывод результатов анализа
            System.out.println("Количество слов в файле: " + wordCount);
            System.out.println("Самое длинное слово в файле: " + longestWord);
            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println("'" + entry.getKey() + "': " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}

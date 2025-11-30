//4
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentProcessor {
    public static void processStudents(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            TreeMap<Integer, List<String>> scoreMap = new TreeMap<>(Comparator.reverseOrder());

            for (String fileLine : lines) {
                String[] parts = fileLine.split(" ");
                if (parts.length >= 4) {
                    try {
                        int school = Integer.parseInt(parts[2]);
                        int score = Integer.parseInt(parts[3]);
                        if (school == 50) {
                            String name = parts[0] + " " + parts[1];
                            scoreMap.computeIfAbsent(score, k -> new ArrayList<>()).add(name);
                        }
                    } catch (NumberFormatException e) {
                        // Пропускаем строки с некорректными числами
                    }
                }
            }

            if (scoreMap.isEmpty()) {
                System.out.println("Нет учеников школы №50 в файле");
                return;
            }

            Map.Entry<Integer, List<String>> firstEntry = scoreMap.firstEntry();
            List<String> topStudents = firstEntry.getValue();

            if (topStudents.size() > 2) {
                System.out.println(topStudents.size());
            } else if (topStudents.size() == 1 && scoreMap.size() > 1) {
                List<String> secondTop = scoreMap.higherEntry(firstEntry.getKey()).getValue();
                if (secondTop.size() > 1) {
                    System.out.println(topStudents.get(0));
                } else {
                    System.out.println(topStudents.get(0));
                    for (String student : secondTop) {
                        System.out.println(student);
                    }
                }
            } else {
                for (String student : topStudents) {
                    System.out.println(student);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
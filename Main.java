import java.io.IOException;
import java.util.List;
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задание 1
        System.out.println("Задание 1:");

        try {
            int numerator = readInt(scanner, "Введите числитель: ");
            int denominator = readInt(scanner, "Введите знаменатель: ");

            Fraction fraction = new Fraction(numerator, denominator);
            System.out.println("Обычная дробь: " + fraction);
            System.out.println("Её вещественное значение: " + fraction.getValue());

            CachedFraction cachedFraction = new CachedFraction(numerator, denominator);
            System.out.println("\nКэшируемая дробь: " + cachedFraction);
            System.out.println("Первый расчёт: " + cachedFraction.getValue());
            System.out.println("Получение из кэша: " + cachedFraction.getValue());

            System.out.println("\nИзменяем числитель на 10:");
            cachedFraction.setNumerator(10);
            System.out.println("После изменения: " + cachedFraction);
            System.out.println("Новое значение: " + cachedFraction.getValue());

            Fraction another = new Fraction(10, denominator);
            System.out.println("\nСравнение дробей:");
            System.out.println("Результат сравнения: " + cachedFraction.equals(another));

            // Задание 2
            System.out.println("\nЗадание 2:");
            System.out.print("Введите имя кота: ");
            String catName = scanner.nextLine();

            Cat cat = new Cat(catName);
            MeowCounter catCounter = new MeowCounter(cat);

            System.out.println();
            MeowUtils.makeAllMeow(catCounter, catCounter, catCounter);

            System.out.println("\nКот мяукнул всего " + catCounter.getCount() + " раз(а).");

            // Задание 3
            System.out.println("\nЗадание 3:");
            List<Integer> list1 = ListUtils.readListFromInput(scanner, "L1");
            List<Integer> list2 = ListUtils.readListFromInput(scanner, "L2");

            System.out.println("Список L1: " + list1);
            System.out.println("Список L2: " + list2);

            List<Integer> common = ListUtils.getCommonElements(list1, list2);
            System.out.println("Общие элементы: " + common);

            List<Integer> merged = ListUtils.mergeSortedLists(list1, list2);
            System.out.println("Объединённый упорядоченный список: " + merged);

            // Задание 4
            System.out.println("\nЗадание 4:");
            StudentProcessor.processStudents("src/students.txt"); // Исправьте путь если нужно

            // Задание 5
            System.out.println("\nЗадание 5:");
            TextAnalyzer.analyzeText("src/text.txt"); // Исправьте путь если нужно

            // Задание 6
            System.out.println("\nЗадание 6:");
            Queue<Integer> queue = QueueUtils.readQueueFromInput(scanner);
            QueueUtils.printQueueInfo(scanner, queue);

            // Задание 7.1
            System.out.println("\nЗадание 7.1:");
            Point[] points = {
                    new Point(1, -2),
                    new Point(3, 4),
                    new Point(2, -1),
                    new Point(1, -2),
                    new Point(5, -3)
            };

            Polyline polyline = new Polyline(
                    Arrays.stream(points)
                            .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                            .distinct()
                            .sorted(Comparator.comparingDouble(Point::getX))
                            .toArray(Point[]::new)
            );
            System.out.println("Результат: " + polyline);

            // Задание 7.2
            System.out.println("\nЗадание 7.2:");
            PersonNumberProcessor personProcessor = new PersonNumberProcessor("src/persons.txt"); // Исправьте путь если нужно

            try {
                personProcessor.readFile();
                Map<Integer, List<String>> grouped = personProcessor.groupByNumber();
                System.out.println("Группировка по номеру: " + grouped);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }
    }
}
//6
import java.util.*;

public class QueueUtils {
    public static boolean checkQueueSegment(Queue<Integer> queue, int i, int j) {
        List<Integer> list = new ArrayList<>(queue);
        if (i >= j || i < 0 || j >= list.size()) return false;

        Integer first = list.get(i);
        for (int k = i + 1; k <= j; k++) {
            if (!list.get(k).equals(first)) return false;
        }
        return true;
    }

    public static Queue<Integer> readQueueFromInput(Scanner scanner) {
        Queue<Integer> queue = new LinkedList<>();

        int size = readPositiveInt(scanner, "Введите количество элементов очереди: ");

        for (int i = 0; i < size; i++) {
            int value = readInt(scanner, (i + 1) + ": ");
            queue.add(value);
        }

        return queue;
    }

    public static void printQueueInfo(Scanner scanner, Queue<Integer> queue) {
        System.out.println("Очередь: " + queue);

        if (queue.size() >= 2) {
            int i = readIntInRange(scanner, "Введите индекс i: ", 0, queue.size() - 2);
            int j = readIntInRange(scanner, "Введите индекс j (больше i): ", i + 1, queue.size() - 1);

            boolean isEqual = checkQueueSegment(queue, i, j);
            System.out.println("Участок с " + i + " по " + j + " элемент одинаковый: " + isEqual);
        } else {
            System.out.println("Очередь слишком мала для проверки участка");
        }
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

    private static int readPositiveInt(Scanner scanner, String message) {
        int value;
        while (true) {
            value = readInt(scanner, message);
            if (value > 0) break;
            System.out.println("Ошибка: число должно быть положительным!");
        }
        return value;
    }

    private static int readIntInRange(Scanner scanner, String message, int min, int max) {
        int value;
        while (true) {
            value = readInt(scanner, message);
            if (value >= min && value <= max) break;
            System.out.println("Ошибка: число должно быть от " + min + " до " + max + "!");
        }
        return value;
    }
}
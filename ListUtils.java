//3
import java.util.*;

public class ListUtils {

    public static List<Integer> getCommonElements(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        for (Integer element : list2) {
            if (list1.contains(element) && !result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        Collections.sort(merged);
        return merged;
    }

    public static List<Integer> readListFromInput(Scanner scanner, String listName) {
        List<Integer> list = new ArrayList<>();

        int size = readPositiveInt(scanner, "Введите количество элементов списка " + listName + ": ");

        for (int i = 0; i < size; i++) {
            int value = readInt(scanner, (i + 1) + ": ");
            list.add(value);
        }

        Collections.sort(list);
        return list;
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
}
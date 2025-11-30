//7
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PersonNumberProcessor {

    private String fileName;
    private List<PersonNumber> persons;

    public PersonNumberProcessor(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        }
        this.fileName = fileName;
        this.persons = new ArrayList<>();
    }

    public void readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            persons = reader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .map(this::parseLine)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
    }

    private PersonNumber parseLine(String line) {
        String[] parts = line.split(":");
        String name = parts[0].trim();
        Integer number = null;

        if (parts.length > 1 && !parts[1].trim().isEmpty()) {
            try {
                number = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException ignored) {
            }
        }

        return new PersonNumber(name, number);
    }

    public Map<Integer, List<String>> groupByNumber() {
        return persons.stream()
                .filter(p -> p.getNumber() != null)
                .collect(Collectors.groupingBy(
                        PersonNumber::getNumber,
                        LinkedHashMap::new,
                        Collectors.mapping(PersonNumber::getName, Collectors.toList())
                ));
    }

    public List<PersonNumber> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return persons.toString();
    }
}
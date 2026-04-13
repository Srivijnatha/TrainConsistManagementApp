import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Bogie{name='" + name + "', capacity=" + capacity + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC9 - Group Bogies by Type (groupingBy) ");
        System.out.println("==============================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("Original Bogie List (Flat):");
        bogies.forEach(System.out::println);

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("\nGrouped Bogie Structure (Categorized):");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + ": " + list);
        });

        System.out.println("\nUC9 grouping completed...");
    }
}
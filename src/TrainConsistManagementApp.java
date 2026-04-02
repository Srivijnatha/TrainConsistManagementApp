import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + "(" + capacity + ")";
    }
}

public class TrainConsistManagementApp {

    // 🔹 UC9 Grouping Method (IMPORTANT FOR TESTING)
    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    public static void main(String[] args) {

        System.out.println("=== UC9: Group Bogies ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 50));
        bogies.add(new Bogie("Sleeper", 65));
        bogies.add(new Bogie("First Class", 30));
        bogies.add(new Bogie("AC Chair", 80));

        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        // 🔹 Print grouped data
        for (String type : grouped.keySet()) {
            System.out.println(type + " -> " + grouped.get(type));
        }
    }
}
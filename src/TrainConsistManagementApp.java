import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // ✅ Bogie Model
    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    // ✅ Reuse: Create bogie list
    public static List<Bogie> createBogies() {
        return Arrays.asList(
                new Bogie("B1", 50),
                new Bogie("B2", 60),
                new Bogie("B3", 70),
                new Bogie("B4", 80)
        );
    }

    // ✅ CORE METHOD (UC10)
    public static int calculateTotalCapacity(List<Bogie> bogies) {

        if (bogies == null) return 0;

        return bogies.stream()
                .map(Bogie::getCapacity)   // extract capacity
                .reduce(0, Integer::sum); // aggregate
    }

    // ✅ Optional display
    public static void displayBogies(List<Bogie> bogies) {
        bogies.forEach(System.out::println);
    }

    // ✅ Main (demo only)
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC10 - Total Seating Capacity باستخدام reduce()");
        System.out.println("==========================================\n");

        List<Bogie> bogies = createBogies();

        displayBogies(bogies);

        int total = calculateTotalCapacity(bogies);

        System.out.println("\nTotal Seating Capacity: " + total);
    }
}
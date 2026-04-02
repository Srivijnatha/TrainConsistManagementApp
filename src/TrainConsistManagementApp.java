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

    // ✅ Method 1: Create default bogie list
    public static List<Bogie> createBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("B1", 50));
        bogies.add(new Bogie("B2", 60));
        bogies.add(new Bogie("B3", 70));
        bogies.add(new Bogie("B4", 80));
        return bogies;
    }

    // ✅ Method 2: Filter logic (CORE METHOD for testing)
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {

        if (bogies == null) {
            return new ArrayList<>(); // handle null safely
        }

        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold) // IMPORTANT: strictly greater
                .collect(Collectors.toList());
    }

    // ✅ Optional: Display method (not used in tests)
    public static void displayBogies(List<Bogie> bogies) {
        if (bogies.isEmpty()) {
            System.out.println("No bogies to display.");
        } else {
            bogies.forEach(System.out::println);
        }
    }

    // ✅ Main method (just for demo, NOT used in tests)
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("==========================================\n");

        List<Bogie> bogies = createBogies();

        int threshold = 60;

        List<Bogie> filteredBogies = filterBogiesByCapacity(bogies, threshold);

        System.out.println("Bogies with capacity greater than " + threshold + ":\n");
        displayBogies(filteredBogies);

        System.out.println("\nOriginal Bogie List (unchanged):");
        displayBogies(bogies);
    }
}
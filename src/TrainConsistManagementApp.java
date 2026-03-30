import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("UC5 - Preserve Insertion Order of Bogies");

        LinkedHashSet<String> train = new LinkedHashSet<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        train.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(train);

        System.out.println("\nNote:");
        System.out.println("Duplicates are not allowed and insertion order is preserved.");

        System.out.println("\nUC5 insertion order validation completed...");
    }
}
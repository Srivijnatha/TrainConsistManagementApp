import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("UC4 - Maintain Ordered Train Consist");

        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC Chair");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(train);

        train.add(2, "Pantry Car");

        train.removeFirst();
        train.removeLast();

        System.out.println("\nFinal Train Consist:");
        System.out.println(train);

        System.out.println("\nUC4 ordering and modification completed...");
    }
}
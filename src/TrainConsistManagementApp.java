import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    // Method to sort bogie names
    public static String[] sortBogieNames(String[] bogies) {
        Arrays.sort(bogies); // Built-in optimized sort
        return bogies;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of bogies:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] bogies = new String[n];

        System.out.println("Enter bogie names:");
        for (int i = 0; i < n; i++) {
            bogies[i] = scanner.nextLine();
        }

        // Sort bogies
        sortBogieNames(bogies);

        // Display sorted result
        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogies));

        scanner.close();
    }
}
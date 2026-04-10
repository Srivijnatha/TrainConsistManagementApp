import java.util.Scanner;

public class TrainConsistManagementApp {

    // Linear Search Method
    public static boolean searchBogieById(String[] bogieIds, String key) {
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) { // equality check using equals()
                return true; // early termination
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of bogies:");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] bogieIds = new String[n];

        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = scanner.nextLine();
        }

        System.out.println("Enter bogie ID to search:");
        String key = scanner.nextLine();

        boolean found = searchBogieById(bogieIds, key);

        if (found) {
            System.out.println("Bogie ID found in the consist.");
        } else {
            System.out.println("Bogie ID not found.");
        }

        scanner.close();
    }
}
public class TrainConsistManagementApp {

    // ✅ Bubble Sort Method
    static void bubbleSort(int[] arr) {

        int n = arr.length;

        // Outer loop → number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop → compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if left > right
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ✅ Utility to print array
    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // ✅ Main method (demo)
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC16 - Bubble Sort (Passenger Capacity)");
        System.out.println("======================================");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        printArray(capacities);

        bubbleSort(capacities);

        System.out.print("After Sorting: ");
        printArray(capacities);
    }
}
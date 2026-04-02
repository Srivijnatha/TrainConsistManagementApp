import java.util.*;

// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private int id;
    private int capacity;
    private String type;

    public PassengerBogie(int id, int capacity, String type) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.id = id;
        this.capacity = capacity;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

// Main Class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie(1, 80, "Sleeper");
            PassengerBogie b2 = new PassengerBogie(2, 0, "General"); // Invalid

            System.out.println("Bogie Created: " + b1.getType() + " Capacity: " + b1.getCapacity());
            System.out.println("Bogie Created: " + b2.getType() + " Capacity: " + b2.getCapacity());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}
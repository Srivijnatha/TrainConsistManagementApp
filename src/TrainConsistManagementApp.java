import java.util.*;
class Bogie {
    String name;
    int capacity;

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
        return name + " - Capacity: " + capacity;
    }
}
public class TrainConsistManagementApp {
    public static void main(String[] args) {
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("Bogies sorted by seating capacity:\n");

        for (Bogie bogie : bogieList) {
            System.out.println(bogie);
        }
    }
}
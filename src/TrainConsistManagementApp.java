import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private int id;
    private int capacity;

    public Bogie(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bogie{id=" + id + ", capacity=" + capacity + "}";
    }
}

public class TrainConsistManagementApp {

    // Loop-based filtering
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // Generate dataset
    public static List<Bogie> generateBogies(int size) {
        List<Bogie> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            list.add(new Bogie(i, 30 + random.nextInt(100)));
        }
        return list;
    }

    public static void main(String[] args) {

        List<Bogie> bogies = generateBogies(10000);

        // LOOP BENCHMARK
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies);
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // STREAM BENCHMARK
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies);
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // OUTPUT
        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        if (loopTime < streamTime) {
            System.out.println("Loop is faster");
        } else {
            System.out.println("Stream is faster");
        }
    }
}
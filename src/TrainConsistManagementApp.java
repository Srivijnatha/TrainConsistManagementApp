import java.util.*;

public class TrainConsistManagementApp {

    // ✅ Goods Bogie Model
    public static class GoodsBogie {
        private String type;   // Cylindrical, Open, Box
        private String cargo;  // Petroleum, Coal, Grain, etc.

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return type + " Bogie carrying " + cargo;
        }
    }

    // ✅ CORE METHOD (Safety Validation)
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {

        if (bogies == null) return true;

        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") // not cylindrical → OK
                                || b.getCargo().equalsIgnoreCase("Petroleum") // cylindrical → must be petroleum
                );
    }

    // ✅ Sample data (optional)
    public static List<GoodsBogie> createSampleBogies() {
        return Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );
    }

    // ✅ Main (demo only)
    public static void main(String[] args) {

        List<GoodsBogie> bogies = createSampleBogies();

        boolean isSafe = isTrainSafe(bogies);

        System.out.println("Train Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));
    }
}
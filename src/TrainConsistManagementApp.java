import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    // ✅ Regex Patterns
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    private static final Pattern trainPattern = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern cargoPattern = Pattern.compile(CARGO_CODE_REGEX);

    // ✅ Validate Train ID
    public static boolean isValidTrainID(String trainId) {
        if (trainId == null || trainId.isEmpty()) return false;

        Matcher matcher = trainPattern.matcher(trainId);
        return matcher.matches(); // exact match
    }

    // ✅ Validate Cargo Code
    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) return false;

        Matcher matcher = cargoPattern.matcher(cargoCode);
        return matcher.matches(); // exact match
    }

    // ✅ Main (demo only)
    public static void main(String[] args) {

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Train ID: " + trainId +
                " → " + (isValidTrainID(trainId) ? "Valid" : "Invalid"));

        System.out.println("Cargo Code: " + cargoCode +
                " → " + (isValidCargoCode(cargoCode) ? "Valid" : "Invalid"));
    }
}
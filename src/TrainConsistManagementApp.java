import java.util.List;

public class TrainConsistManagementApp {

    private List<String> bogies;

    public TrainConsistManagementApp(List<String> bogies) {
        this.bogies = bogies;
    }

    public boolean searchBogie(String bogieId) {

        // 🔴 Fail-fast validation
        if (bogies == null || bogies.isEmpty()) {
            throw new IllegalStateException("Cannot perform search: No bogies available in the train consist.");
        }

        // 🔍 Search logic
        for (String bogie : bogies) {
            if (bogie.equals(bogieId)) {
                return true;
            }
        }

        return false;
    }
}
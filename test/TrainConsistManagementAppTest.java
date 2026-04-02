import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = Arrays.asList(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal"), // violation
                new TrainConsistManagementApp.GoodsBogie("Open", "Grain")
        );

        assertFalse(TrainConsistManagementApp.isTrainSafe(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = new ArrayList<>();

        assertTrue(TrainConsistManagementApp.isTrainSafe(bogies));
    }
}
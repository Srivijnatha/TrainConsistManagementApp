import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TestConsistManagementAppTest {

    // Helper method to create test data
    private List<TrainConsistManagementApp.Bogie> getBogies() {
        return Arrays.asList(
                new TrainConsistManagementApp.Bogie("B1", 50),
                new TrainConsistManagementApp.Bogie("B2", 60),
                new TrainConsistManagementApp.Bogie("B3", 70),
                new TrainConsistManagementApp.Bogie("B4", 80)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 60);

        assertEquals(2, result.size()); // B3, B4
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 60);

        // Should NOT include B2 (equal case)
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 60));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 60);

        // Should NOT include B1
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 60));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 55);

        assertEquals(3, result.size()); // B2, B3, B4
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 100);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(getBogies(), 10);

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Bogie> result =
                TrainConsistManagementApp.filterBogiesByCapacity(new ArrayList<>(), 50);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies();

        TrainConsistManagementApp.filterBogiesByCapacity(bogies, 60);

        // Original list should remain same size
        assertEquals(4, bogies.size());
    }
}
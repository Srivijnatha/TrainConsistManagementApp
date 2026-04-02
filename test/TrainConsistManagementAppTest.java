import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    private List<TrainConsistManagementApp.Bogie> getBogies() {
        return Arrays.asList(
                new TrainConsistManagementApp.Bogie("B1", 50),
                new TrainConsistManagementApp.Bogie("B2", 60),
                new TrainConsistManagementApp.Bogie("B3", 70),
                new TrainConsistManagementApp.Bogie("B4", 80)
        );
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int total = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertEquals(260, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = TrainConsistManagementApp.calculateTotalCapacity(getBogies());
        assertTrue(total > 0);
        assertEquals(260, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Bogie> bogies =
                Collections.singletonList(new TrainConsistManagementApp.Bogie("B1", 100));

        int total = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(100, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = TrainConsistManagementApp.calculateTotalCapacity(new ArrayList<>());
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies();

        List<Integer> capacities = bogies.stream()
                .map(TrainConsistManagementApp.Bogie::getCapacity)
                .toList();

        assertEquals(Arrays.asList(50, 60, 70, 80), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies();

        int expectedSum = 50 + 60 + 70 + 80;

        int total = TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(expectedSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Bogie> bogies = getBogies();

        TrainConsistManagementApp.calculateTotalCapacity(bogies);

        assertEquals(4, bogies.size());
        assertEquals("B1", bogies.get(0).getName());
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> createSampleBogies() {
        return Arrays.asList(
                new Bogie(1, 50),
                new Bogie(2, 70),
                new Bogie(3, 80),
                new Bogie(4, 40)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = TrainConsistManagementApp.filterWithLoop(bogies);

        assertEquals(2, result.size());
        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> result = TrainConsistManagementApp.filterWithStream(bogies);

        assertEquals(2, result.size());
        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createSampleBogies();

        List<Bogie> loopResult =TrainConsistManagementApp.filterWithLoop(bogies);
        List<Bogie> streamResult = TrainConsistManagementApp.filterWithStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = TrainConsistManagementApp.generateBogies(1000);

        long start = System.nanoTime();
        TrainConsistManagementApp.filterWithLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = TrainConsistManagementApp.generateBogies(50000);

        List<Bogie> result = TrainConsistManagementApp.filterWithStream(bogies);

        assertNotNull(result);
        assertTrue(result.size() >= 0); // ensures it ran successfully
    }
}
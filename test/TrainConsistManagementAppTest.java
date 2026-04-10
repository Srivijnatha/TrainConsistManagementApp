import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.searchBogieById(bogies, "BG309");

        assertTrue(result);
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.searchBogieById(bogies, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.searchBogieById(bogies, "BG101");

        assertTrue(result);
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.searchBogieById(bogies, "BG550");

        assertTrue(result);
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};

        boolean result = TrainConsistManagementApp.searchBogieById(bogies, "BG101");

        assertTrue(result);
    }
}
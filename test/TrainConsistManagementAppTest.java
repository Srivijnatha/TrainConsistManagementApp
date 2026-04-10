import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG309");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG999");

        assertFalse(result);
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG101");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101","BG205","BG309","BG412","BG550"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG550");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG101");

        assertTrue(result);
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG101");

        assertFalse(result);
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309","BG101","BG550","BG205","BG412"};

        boolean result = TrainConsistManagementApp.binarySearchBogie(bogies, "BG205");

        assertTrue(result);
    }
}
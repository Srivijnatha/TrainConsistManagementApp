import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        TrainConsistManagementApp manager =
                new TrainConsistManagementApp(Collections.emptyList());

        assertThrows(IllegalStateException.class, () -> {
            manager.searchBogie("BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        TrainConsistManagementApp manager =
                new TrainConsistManagementApp(Arrays.asList("BG101", "BG205"));

        assertDoesNotThrow(() -> {
            manager.searchBogie("BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        TrainConsistManagementApp manager =
                new TrainConsistManagementApp(Arrays.asList("BG101", "BG205", "BG309"));

        assertTrue(manager.searchBogie("BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        TrainConsistManagementApp manager =
                new TrainConsistManagementApp(Arrays.asList("BG101", "BG205", "BG309"));

        assertFalse(manager.searchBogie("BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        TrainConsistManagementApp manager =
                new TrainConsistManagementApp(Arrays.asList("BG101"));

        assertTrue(manager.searchBogie("BG101"));
    }
}
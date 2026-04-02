import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie(1, 75, "AC");

        assertNotNull(bogie);
        assertEquals(75, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie(2, -10, "General");
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie(3, 0, "Sleeper");
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie(4, -5, "AC");
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie(5, 100, "Sleeper");

        assertEquals(5, bogie.getId());
        assertEquals(100, bogie.getCapacity());
        assertEquals("Sleeper", bogie.getType());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie(1, 50, "General"));
        bogies.add(new PassengerBogie(2, 70, "Sleeper"));
        bogies.add(new PassengerBogie(3, 90, "AC"));

        assertEquals(3, bogies.size());

        for (PassengerBogie b : bogies) {
            assertTrue(b.getCapacity() > 0);
        }
    }
}
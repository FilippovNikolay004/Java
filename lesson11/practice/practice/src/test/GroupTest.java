package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.nikolay.test.Group;

@DisplayName("Tests for the Group class")
class GroupTest {

    private Group group;
    private static final String VALID_NAME = "КНП-221";

    @BeforeEach
    void setUp() {
        group = new Group(VALID_NAME);
    }

    @Test
    @DisplayName("Verify group creation with a valid name and an empty student list")
    void testCreateGroup() {
        assertAll("Group initialization",
            () -> assertEquals(VALID_NAME, group.getGroupName(), "Group name should match the provided value"),
            () -> assertTrue(group.getStudents().isEmpty(), "Student list should be empty"),
            () -> assertEquals(0, group.getStudentCount(), "Student count should be 0")
        );

        assertThrows(UnsupportedOperationException.class,
            () -> group.getStudents().add(null),
            "Student list should be unmodifiable");
    }
}
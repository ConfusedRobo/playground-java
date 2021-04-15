package practice.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private static Integer[][] testConditions() {
        return new Integer[][]{{0, 0}, {1, 1}, {2, 1}, {3, 2}, {4, 3}, {5, 5}, {10, 55}};
    }

    @ParameterizedTest
    @MethodSource("testConditions")
    void fibLinear_test(int term, int expected) {
        assertEquals(expected, Main.fibLinear(term));
    }
}

import testing.ArrayAfterFour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArrayAfterFour {
    ArrayAfterFour arrayAfterFour = new ArrayAfterFour();
    Integer[] input1 = {1, 2, 3, 4, 5, 6};
    Integer[] output1 = {5, 6};

    Integer[] input2 = {4, 2, 3, 1, 5, 6};
    Integer[] output2 = {2, 3, 1, 5, 6};
    Integer[] input3 = {1, 2, 3, 4, 5, 4};
    Integer[] output3 = null;
    Integer[] input4 = {4, 4, 4, 1, 5, 6};
    Integer[] output4 = {1, 5, 6};
    Integer[] inputToCauseException = {0, 0};

    @Test
    public void testArrayOutput1() {
        Assertions.assertArrayEquals(output1, arrayAfterFour.getArrayAfterLastFour(input1));
    }

    @Test
    public void testArrayOutput2() {
        Assertions.assertArrayEquals(output2, arrayAfterFour.getArrayAfterLastFour(input2));
    }

    @Test
    public void testArrayOutput3() {
        Assertions.assertArrayEquals(output3, arrayAfterFour.getArrayAfterLastFour(input3));
    }

    @Test
    public void testArrayOutput4() {
        Assertions.assertArrayEquals(output4, arrayAfterFour.getArrayAfterLastFour(input4));
    }

    @Test
    public void catchException() {
        Assertions.assertThrows(RuntimeException.class, () -> arrayAfterFour.getArrayAfterLastFour(inputToCauseException));
    }
}

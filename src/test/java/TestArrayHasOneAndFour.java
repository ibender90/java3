import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testing.ArrayHasOneAndFour;

public class TestArrayHasOneAndFour {
    ArrayHasOneAndFour arrayHasOneAndFour = new ArrayHasOneAndFour();

    Integer[] input1 = {1, 2, 3, 4, 5};
    Integer[] input2 = {1, 2, 3, 5, 5};

    Integer[] input3 = {1, 1};
    Integer[] input4 = {4, 4};


    @Test
    public void testArrayHasOneAndFourInput1() {
        Assertions.assertTrue(arrayHasOneAndFour.hasOneAndFour(input1));
    }

    @Test
    public void testArrayHasOneAndFourInput2() {
        Assertions.assertFalse(arrayHasOneAndFour.hasOneAndFour(input2));
    }

    @Test
    public void testArrayHasOneAndFourInput3(){
        Assertions.assertFalse(arrayHasOneAndFour.hasOneAndFour(input3));
    }

    @Test
    public void testArrayHasOneAndFourInput4(){
        Assertions.assertFalse(arrayHasOneAndFour.hasOneAndFour(input4));
    }
}

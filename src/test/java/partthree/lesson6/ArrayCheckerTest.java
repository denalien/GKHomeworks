package partthree.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrayCheckerTest {
    private boolean control;
    private int[] input;

    public ArrayCheckerTest(boolean control, int[] input) {
        this.control = control;
        this.input = input;
    }

    ArrayHandler arrayHandler;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {false, new int[]{1,1,1,3,4,4,4}},
                {true, new int[]{1,1,1,1,4,4,4}},
                {false, new int[]{4,4,4}},
                {false, new int[]{1,1,1}}
        });
    }

    @Before
    public void init() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    public void arrayCheckerTest(){
        Assert.assertEquals(control,arrayHandler.arrayChecker(input));
    }
}

package partthree.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ArraySplitterTest {

    private int[] control;
    private int[] input;

    public ArraySplitterTest(int[] control, int[] input) {
        this.control = control;
        this.input = input;
    }

    ArrayHandler arrayHandler;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{1,5,2,3,4}},
                {new int[]{3}, new int[]{1,5,2,4,3}},
                {new int[]{2,3,5}, new int[]{1,4,2,3,5}},
                {new int[]{3,1}, new int[]{1,4,4,3,1}}
        });
    }

    @Before
    public void init() {
        arrayHandler = new ArrayHandler();
    }

    @Test
    public void arraySplitterTest(){
        Assert.assertArrayEquals(control, arrayHandler.arraySplitter(input));
    }

    @Test(expected = RuntimeException.class)
    public void arraySplitterExceptionTest(){
        int[] input = {1,1,1,1,1};
        arrayHandler.arraySplitter(input);
    }

}

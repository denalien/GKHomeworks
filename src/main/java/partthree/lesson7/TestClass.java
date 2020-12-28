package partthree.lesson7;

public class TestClass {

    @BeforeSuite
    public static void before(){
        System.out.println("I'm running at the beginning");
    }

    @Test(priority = 1)
    public static void testMethod1(){
        System.out.println("Method 1 tested");
    }
    @Test(priority = 2)
    public static void testMethod2(){
        System.out.println("Method 2 tested");
    }
    @Test
    public static void testMethod3(){
        System.out.println("Method 3 tested");
    }
    @Test (priority = 4)
    public static void testMethod4(){
        System.out.println("Method 4 tested");
    }

    @AfterSuite
    public static void after(){
        System.out.println("I'm running in the end");
    }
}

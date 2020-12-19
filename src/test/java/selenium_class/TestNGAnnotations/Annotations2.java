package selenium_class.TestNGAnnotations;


import org.testng.annotations.Test;

public class Annotations2 {


    @Test(invocationCount = 10, priority = 0)
    public void test1(){
        System.out.println("Test 1 execution");

    }

    @Test(invocationCount = 10, priority = -1)
    public void test2(){
        System.out.println("Test 2 execution");
    }


    //We can declare 2 or more Exceptions. If test can throw one of these exceptions it will pass.
    @Test(expectedExceptions = {ArithmeticException.class, RuntimeException.class})
    public void test3(){

        System.out.println("Test 3 execution");
        throw new ArithmeticException();
    }


}

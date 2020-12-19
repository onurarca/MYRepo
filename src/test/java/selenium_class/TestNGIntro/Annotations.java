package selenium_class.TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Annotations {

    @Test
    public void testB(){
        System.out.println("test Annotation 1");
        String expectedTitle = "Techtorial";
        Assert.assertEquals("Tech",expectedTitle);
        //Hard Assertion If assert fails, the code stop running and next line will not be executed
        System.out.println("Test is passed");


    }

    @Test
    public void testA(){

        System.out.println("Test Annotation 2");
        String expectedUrl = "www.google.com";
        String actualUrl = "www.google.com";

        Assert.assertTrue((expectedUrl.equals(actualUrl)));
    }


}

package selenium_class.TestNGAnnotations;

import org.testng.annotations.*;

public class Annotations {


    @Test
    public void test1(){
        System.out.println("Test Annotation 1");


    }

    @Test
    public void test2(){
        System.out.println("Test Annotation 2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method Annotation");
    }

    @AfterMethod
    public void afterMethodAnnotation(){
        System.out.println("After Method Annotation");


    }

    @BeforeClass
    public void beforeClassAnnotation(){
        System.out.println("Before CLASS Annotation");
    }

    @AfterClass
    public void afterClassAnnotation(){
        System.out.println("After CLASS Annotation");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test Annotation");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test Annotation");
    }

    @BeforeSuite
    public void beforeSuitAnnotation(){
        System.out.println("Before Suit Annotation");
    }
    @AfterSuite
    public void afterSuiteAnnotation(){
        System.out.println("After Suit Annotation");
    }




}

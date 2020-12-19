package selenium_class.TestNGAnnotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotationPractice {

    //We need to use parameter annotation with xml file bc the values for our
    //parameter will come from xml file.

    @Parameters({"FirstName","lastName"})
    @Test
    public void printName(String name, String lastName){
        System.out.println("The name is : " + name);
        System.out.println("The last name is : "+lastName);
    }

}

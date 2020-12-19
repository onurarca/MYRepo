package cucumber_class.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){

        System.out.println("Before Hook has been executed");
    }

    @After
    public void cleanup(){

        System.out.println("After Hook has been executed");

    }







}

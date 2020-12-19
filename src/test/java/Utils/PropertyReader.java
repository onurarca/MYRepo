package Utils;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class PropertyReader {


    public static String readPropertyByKey(String key) {
        Properties properties = new Properties();
        File propertiesFile = new File("src/test/resources/credentials.properties");
        try {
            FileInputStream input = new FileInputStream(propertiesFile);
            properties.load(input);

        }catch (IOException ex){
            throw new RuntimeException("Credentials.properties file was not found", ex);
        }
        
        return properties.getProperty(key);



    }



    @Test
    public void test1() throws IOException {

        Properties properties = new Properties();

        File propertiesFile = new File("src/test/resources/credentials.properties");
        FileInputStream input = new FileInputStream(propertiesFile);

        properties.load(input);

        //getProperty returns regular string
        String username = properties.getProperty("username");
        System.out.println("Username from properties file: "+ username);

        String password = properties.getProperty("password");
        System.out.println("Password is: "+password);

        String browserInfo = properties.getProperty("browser");
        System.out.println("Browser is: "+browserInfo);

        String environmentInfo = properties.getProperty("environment");
        System.out.println("Environment is: "+ environmentInfo);



    }


}

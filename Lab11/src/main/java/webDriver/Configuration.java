package webDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    public static void init(){
        properties = new Properties();
        try{
            properties.load((new FileInputStream("/elements.properties")));
        }catch (IOException e){
            System.out.println("Can't read property");
        }
    }
    private static Properties getProperties(){
        if(properties == null){
            init();
        }
        return properties;
    }
}

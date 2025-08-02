package phrases.dto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    public static Properties loadProperties(String path) throws IOException{

        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream(path)){
            props.load(fis);
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }

        return props;
    }
}

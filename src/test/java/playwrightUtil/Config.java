package playwrightUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties;
    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/Config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    public static String getValue(String name) {
        return properties.getProperty(name);
    }
}

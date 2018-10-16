package common;

import java.io.InputStream;
import java.util.Properties;

public class ConnectToProperties {
    public static String getConnectionUrl() {
        String url = null;
        try (InputStream stream = ConnectToProperties
                .class.getClassLoader()
                .getResourceAsStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(stream);
            url = properties.getProperty("url")
                    + properties.getProperty("serverName") + ":"
                    + properties.getProperty("portNumber")
                    + "; databaseName = " + properties.getProperty("databaseName")
                    + "; user = " + properties.getProperty("user")
                    + "; password = " + properties.getProperty("password")
                    + ";";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            url = null;
        }
        return url;
    }

    public static void main(String[] args) {
        System.out.println(getConnectionUrl());
    }
}

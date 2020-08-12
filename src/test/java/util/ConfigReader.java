package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Muntakim
 */
public class ConfigReader {

    private String url;
    private String chromeDriverPath;
    private String mobilePlatformName;
    private String mobileAutomationName;
    private String mobileVersion;
    private String mobileDeviceName;
    private String mobileAppPath;

    private String run_test;
    private String Platform;
    private String SauceBrowswer;
    private String environment;
    private String Version;
    private String SauceUsername;
    private String sauceKey;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");
            this.mobilePlatformName = prop.getProperty("mobile_platform_name");
            this.mobileAutomationName = prop.getProperty("mobile_automation_name");
            this.mobileVersion = prop.getProperty("mobile_version");
            this.mobileAppPath = prop.getProperty("mobile_app_path");
            this.mobileDeviceName = prop.getProperty("mobile_device");

            //this.url=prop.getProperty("url");
            this.environment= prop.getProperty("run_test");
            this.SauceBrowswer =prop.getProperty("browser");
            this.Platform =prop.getProperty("platform");
            this.Version = prop.getProperty("version");
            this.chromeDriverPath=prop.getProperty("chrome_driver_path");
            this.SauceUsername=prop.getProperty("sauce_username");
            this.sauceKey=prop.getProperty("sauce_key");


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {

        return url;
    }

    public String getChromeDriverPath() {

        return chromeDriverPath;
    }

    public String getMobilePlatformName() {
        return mobilePlatformName;
    }

    public String getMobileAutomationName() {
        return mobileAutomationName;
    }

    public String getMobileVersion() {
        return mobileVersion;
    }

    public String getMobileDeviceName() {
        return mobileDeviceName;
    }

    public String getMobileAppPath() {
        return mobileAppPath;
    }

    public String getEnvironment(){ return environment; }

    public String getSauceBrowswer(){return SauceBrowswer;}

    public String getPlatform(){return Platform;}

    public String getVersion() { return Version; }

    public String getSauceUsername(){return SauceUsername;}

    public String getSauceKey() { return sauceKey; }
}


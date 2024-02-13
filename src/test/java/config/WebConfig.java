package config;
import org.aeonbits.owner.Config;
import java.net.URL;
@Config.Sources({
        "classpath:${envWeb}.properties"
})
public interface WebConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://smart-lab.ru")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remote")
    String getRemote();
}

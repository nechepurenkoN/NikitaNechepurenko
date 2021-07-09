package di;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSingleton extends AbstractModule {
    @Override
    protected void configure() {
        DriverManagerType browserType = DriverModule.getBrowserType();
        WebDriverManager.getInstance(browserType).setup();
        if (Objects.isNull(System.getProperty("browser.remote"))) {
            injectDriverAsSingleton(browserType);
        } else {
            injectRemoteDriverAsInstance(browserType);
        }
    }

    private void injectRemoteDriverAsInstance(DriverManagerType browserType) {
        Capabilities capabilities = getCapabilitiesForBrowserName(browserType.getBrowserName());
        RemoteWebDriver remoteDriver = null;
        try {
            remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        bind(WebDriver.class)
            .toInstance(remoteDriver);
    }

    @SneakyThrows
    private void injectDriverAsSingleton(DriverManagerType browserType) {
        bind(WebDriver.class)
            .to((Class<? extends WebDriver>) Class.forName(browserType.browserClass()))
            .in(Singleton.class);
    }

    @SneakyThrows
    private void injectDriverAsInstance(DriverManagerType browserType) {
        bind(WebDriver.class)
            .toInstance((WebDriver) Class.forName(browserType.browserClass()).getConstructor().newInstance());
    }

    private Capabilities getCapabilitiesForBrowserName(String browserName) {
        if (CHROME.equalsIgnoreCase(browserName)) {
            return new ChromeOptions();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            return new FirefoxOptions();
        } else {
            throw new IllegalArgumentException(
                String.format("Unsupported browser type %s for remote browser", browserName)
            );
        }
    }
}

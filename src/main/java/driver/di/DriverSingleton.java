package driver.di;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class DriverSingleton extends AbstractModule {
    @Override
    protected void configure() {
        DriverManagerType browserType = DriverModule.getBrowserType();
        WebDriverManager.getInstance(browserType).setup();
        injectDriverAsSingleton(browserType);
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
}

package driver;

import com.google.inject.Inject;
import driver.di.DriverModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Guice;

@Guice(modules = {DriverModule.class})
public class DriverFactory {
    @Inject
    private DriverManagerType browserUsedType;

    protected void setUpDriver() {
        WebDriverManager.getInstance(browserUsedType).setup();
    }

    @SneakyThrows
    public WebDriver getDriver() {
        setUpDriver();
        return (WebDriver) Class.forName(browserUsedType.browserClass()).getConstructor().newInstance();
    }
}

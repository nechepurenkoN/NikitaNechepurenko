package ru.training.at.hw2.di;

import com.google.inject.AbstractModule;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import java.util.Arrays;
import java.util.Properties;
import lombok.SneakyThrows;

public class DriverModule extends AbstractModule {
    private static final String DRIVER_CONFIG_PATH = "/testngconfigs/seleniumconfig.xml";
    private static final String BROWSER_PROPERTY_NAME = "browser";

    @Override
    protected void configure() {
        bind(DriverManagerType.class)
            .toInstance(getBrowserType());
    }

    private DriverManagerType getBrowserType() {
        String browser = getBrowserNameFromConfig();
        return Arrays.stream(DriverManagerType.values())
                     .filter(dmt -> dmt.getBrowserName().equals(browser))
                     .findAny()
                     .orElse(DriverManagerType.CHROME);
    }

    @SneakyThrows
    private String getBrowserNameFromConfig() {
        Properties prop = new Properties();
        prop.loadFromXML(DriverModule.class.getResourceAsStream(DRIVER_CONFIG_PATH));
        return prop.getProperty(BROWSER_PROPERTY_NAME);
    }
}

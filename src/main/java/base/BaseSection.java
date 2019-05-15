package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import utilities.PropertiesLoader;

public abstract class BaseSection {
    protected static final Logger log = LogManager.getLogger(Logger.class.getName());
    protected PropertiesLoader propertiesLoader;
    protected WebDriver driver;

    public BaseSection(WebDriver driver) {
        propertiesLoader = new PropertiesLoader();
        this.driver = driver;

        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);

        log.debug(getClass().getName() + " -> Initializing elements");
    }

    public abstract boolean isInitialized();
}

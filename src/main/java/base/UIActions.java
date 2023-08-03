package base;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class UIActions {
    public WebElement findElement(By locator, WaitStrategy waitStrategy) {
        return ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
    }

    public void clickOn(By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.click();
    }

    public void writeIn(String text, By locator, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.sendKeys(text);
    }

    public List<WebElement> findElements(By locator, WaitStrategy waitStrategy) {
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }



    public void chooseFromMenu(By menuLocator, String element) {
        clickOn(menuLocator, WaitStrategy.VISIBLE);
        List<WebElement> options = findElements(menuLocator, WaitStrategy.PRESENCE);
        for (WebElement option : options) {
            if (option.getText().contains(element)) {
                option.click();
                break;
            }
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}

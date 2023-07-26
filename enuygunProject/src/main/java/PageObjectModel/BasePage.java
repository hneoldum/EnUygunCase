package PageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Driver;



import java.nio.charset.StandardCharsets;

public class BasePage {
   //protected Logger logger= (Logger) LoggerFactory.getLogger(getClass());
    static Logger logger= LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver= Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(driver,10);

    public void clickElement(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("clicked Element : "+element);
    }
    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sendKeys(WebElement sendKeysElement,String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
        logInfo("send values: "+value+" to element: "+sendKeysElement);
        logger.info("send values: "+value+" to element: "+sendKeysElement);
    }
    private void setLogger(String... classname) {
        String classN = BasePage.class.getName();
        if (classname.length > 0) {
            classN = classname[0];
        }

    }
    public void logInfo(String message, String... classname) {
        try {
            String str = new String(message.getBytes(StandardCharsets.UTF_8));
            this.setLogger(classname);
          //  this.logger.info(str);
        } catch (Throwable var) {
            throw var;
        }
    }
    public synchronized void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);", new Object[0]);
        this.logInfo("Scrolled to bottom");
    }
    public synchronized void hoverElement(By locator) {

        Actions actions = new Actions(this.driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
        this.logInfo("Hovered on element:  '" + locator);
    }
}

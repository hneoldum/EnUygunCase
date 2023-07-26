package PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Driver;

import java.util.concurrent.TimeUnit;


public class BookingFlightsPage extends BasePage {
    private WebDriver driver;
    public BookingFlightsPage() {
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    public void navigateToWebsite(String Url){

        driver= Driver.getDriver();
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @FindBy(id="OriginInput")
    private WebElement departureInput;

    @FindBy(id="DestinationInput")
    private WebElement destinationInput;

    @FindBy(xpath="//*[@class='PassengerBox__body']")
    private WebElement passengerSelectionBox;

    @FindBy(xpath="//*[@data-testid='passengerSelectButtonMulti']")
    private WebElement passengerSelectionButton;

    @FindBy(xpath="//*[@data-testid='okButtonMulti']")
    private WebElement passengerSelectionOkButton;
    @FindBy(id="DepartureDate")
    private WebElement departureDate;
    @FindBy(id="oneWayCheckbox")
    private WebElement oneWayCheckbox;

    @FindBy(id="ReturnDate")
    private WebElement returnDate;
    @FindBy(xpath="//*[@aria-label='Move forward to switch to the next month.']")
    private WebElement dateNextIconButton;
    @FindBy(xpath="//button[@data-testid='formSubmitButton']")
    private WebElement findDealsButton;
    @FindBy(xpath="//div[@data-testid=\"passengerTypeItem-0\"]//span[@class=\"PassengerBox__type__count\"]")
    private WebElement adultNum;

    @FindBy(xpath="//*[@data-testid=\"passengerCountIncrease-0\"]")
    private WebElement adultIncrease;

    @FindBy(xpath="//*[@data-testid=\"passengerCountDecrease-0\"]")
    private WebElement adultDecrease;
    @FindBy(xpath="//div[@data-testid=\"passengerTypeItem-3\"]//span[@class=\"PassengerBox__type__count\"]")
    private WebElement seniorNum;

    @FindBy(xpath="//*[@data-testid=\"passengerCountIncrease-3\"]")
    private WebElement seniorIncrease;

    @FindBy(xpath="//*[@data-testid=\"passengerCountDecrease-3\"]")
    private WebElement seniorDecrease;
    @FindBy(xpath="//div[@data-testid=\"passengerTypeItem-4\"]//span[@class=\"PassengerBox__type__count\"]")
    private WebElement studentNum;

    @FindBy(xpath="//*[@data-testid=\"passengerCountIncrease-4\"]")
    private WebElement studentIncrease;
    @FindBy(xpath="//*[@data-testid=\"passengerCountDecrease-4\"]")
    private WebElement studentDecrease;
    @FindBy(xpath="//div[@data-testid=\"passengerTypeItem-1\"]//span[@class=\"PassengerBox__type__count\"]")
    private WebElement childNum;

    @FindBy(xpath="//*[@data-testid=\"passengerCountIncrease-1\"]")
    private WebElement childIncrease;

    @FindBy(xpath="//*[@data-testid=\"passengerCountDecrease-1\"]")
    private WebElement childDecrease;

    @FindBy(xpath="//*[@data-testid=\"passengerCountIncrease-2\"]")
    private WebElement infantIncrease;

    @FindBy(xpath="//div[@class='CalendarMonth CalendarMonth_1' and @data-visible='true']//strong")
    private WebElement calendarMonthText;

    @FindBy(xpath="//div[@class='searchFormGraphic col tr']")
    private WebElement flightsPageSearchForm;

    public void typeDepartureCity(String departureCity){
        clickElement(departureInput);
        sendKeys(departureInput,departureCity);
        clickElement(driver.findElement(By.xpath("//*[@id='react-autowhatever-OriginInput']//li[@role='option']//strong[contains(text(),'"+departureCity+"')]")));
    }
    public void typeDestinationCity(String destinationCity){
        clickElement(destinationInput);
        sendKeys(destinationInput,destinationCity);
        clickElement(driver.findElement(By.xpath("//*[@id='react-autowhatever-DestinationInput']//li[@role='option']//strong[contains(text(),'"+destinationCity+"')]")));
    }
    public void selectPassenger(String passengerType, int passengerCount){
        try{

            if (passengerSelectionBox.isDisplayed()){
            }

        }catch (NoSuchElementException e) {
            clickElement(passengerSelectionButton);
        }


        int adultCount=Integer.parseInt(adultNum.getText());
        int seniorCount= Integer.parseInt(seniorNum.getText());
        int studentCount= Integer.parseInt(studentNum.getText());

        switch (passengerType){
            case "Adult":
                if (passengerCount<1) {
                    Assert.fail("Adult should be at least 1.");
                }
                else {
                    if (adultCount<passengerCount) {
                         for (int i =adultCount;i<passengerCount;i++){
                        clickElement(adultIncrease);
                         }
                     }
                    else if (adultCount>passengerCount) {
                        for (int i =passengerCount;i<adultCount;i++) {
                        clickElement(adultDecrease);
                        }
                    }
                }
                break;
            case "Child":
                if (adultNum.getText().equals("0")
                        && seniorNum.getText().equals("0")
                        && studentNum.getText().equals("0"))
                {
                    Assert.fail("For Child, at least 1 adult, student or senior should be.");
                }
                else {
                    int childCount= Integer.parseInt(childNum.getText());
                    if (childCount<passengerCount) {
                        for (int i =childCount;i<passengerCount;i++){
                            clickElement(childIncrease);
                        }
                    }
                    else if (childCount>passengerCount) {
                        for (int i =passengerCount;i<childCount;i++) {
                            clickElement(childDecrease);
                        }
                    }
                }
                break;
            case "Infant":
                 if (passengerCount>1){ //infant number can not > 1
                    Assert.fail("Should be 1 infant.");
                }
                else {
                    if (adultNum.getText().equals("0")
                            &&seniorNum.getText().equals("0")) {
                        Assert.fail("For Infant, at least 1 adult or senior should be.");
                    }
                    else {
                        clickElement(infantIncrease);
                    }
                }
                break;
            case "Senior":
                clickElement(adultDecrease);
                if (seniorCount<passengerCount) {
                    for (int i =seniorCount;i<passengerCount;i++){
                        clickElement(seniorIncrease);
                    }
                }
                else if (seniorCount>passengerCount) {
                    for (int i =passengerCount;i<seniorCount;i++) {
                        clickElement(seniorDecrease);
                    }
                }
                break;
            case "Student":
                clickElement(adultDecrease);
                if (studentCount<passengerCount) {
                    for (int i =studentCount;i<passengerCount;i++){
                        clickElement(studentIncrease);
                    }
                }
                else if (studentCount>passengerCount) {
                    for (int i =passengerCount;i<studentCount;i++) {
                        clickElement(studentDecrease);
                    }
                }
                break;
            default:
        clickElement(passengerSelectionOkButton);
        }
    }
    public void selectDepartureDate(String date) throws org.openqa.selenium.NoSuchElementException{
        if (date.equals("")) {
            Assert.fail("Date is Empty");
        } else {
        clickElement(departureDate);
         String data= calendarMonthText.getText();
            int a=0;
            while(!date.contains(data) && a<10) {
                clickElement(dateNextIconButton);
                data = calendarMonthText.getText();
                a++;
            }
            clickElement(driver.findElement(By.xpath("//td[contains(@aria-label,'"+date+"')]")));
        }
    }

    public void clickTransitCheckbox(){
      clickElement(oneWayCheckbox);
    }
    public void selectReturnDate(String date){
        if (date.equals("")){
            Assert.fail("date is empty");
        }else {
            clickElement(returnDate);
            String data= calendarMonthText.getText();
            int a=0;
            while(!date.contains(data) && a<10) {
                clickElement(dateNextIconButton);
                data =calendarMonthText.getText();
                a++;
            }
            clickElement(driver.findElement(By.xpath("//td[contains(@aria-label,'"+date+"')]")));
        }
    }
    public void clickFindDealsButton(){
        clickElement(findDealsButton);
    }
    public void verifyTheSearchPage(){
        wait.until(ExpectedConditions.visibilityOf(flightsPageSearchForm));

    }

    public void clickthevideo(){
        hoverElement(By.xpath("//h2[@tabindex]"));
        scrollToBottom();
        scrollToBottom();
        scrollToBottom();
        scrollToBottom();
        scrollToBottom();
        clickElement(driver.findElement(By.xpath("(//*[contains(text(),'Reject all')])[2]")));
        clickElement(driver.findElement(By.xpath("(//a[@id='thumbnail'])[2]")));

    }

}

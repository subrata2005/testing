package pages;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
	}

	//Locators for various page objects
	By forenameField = By.id("forename");
	By surnameField = By.id("surname");
	By emailField = By.id("email");
	By telephoneField = By.id("telephone");
	By messageField = By.id("message");
	By submitButton = By.linkText("Submit");
	By back = By.linkText("« Back");

	//Methods to enter data in various fields
	public void dataForename(String strForename) {
		driver.findElement(forenameField).sendKeys(strForename);
	}

	public void dataSurnameField(String strSurname) {
		driver.findElement(surnameField).sendKeys(strSurname);
	}

	public void dataEmailField(String strEmail) {
		driver.findElement(emailField).sendKeys(strEmail);
	}

	public void dataMessageField(String strMessage) {
		driver.findElement(messageField).sendKeys(strMessage);
	}

	public void dataTelephoneField(String strTelephone) {
		driver.findElement(telephoneField).sendKeys(strTelephone);
	}

	public void clickBack() {
		driver.findElement(back).click();
	}
	public String successExists() {
		String message = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
		return message;
	}

	public void requiredErrMsg(String expectedMessage,String expectedMessage2,String expectedMessage3,String expectedMessage4, Boolean flag){
		WebElement webEl =driver.findElement(By.tagName("body"));
		if (flag == true) {
			if (webEl.getText().contains(expectedMessage)) {
				assertTrue(true, expectedMessage + " is present");
			} 
			if (webEl.getText().contains(expectedMessage2)){
				assertTrue(true, expectedMessage2 + " is present");
			}
			if (webEl.getText().contains(expectedMessage3)) {
				assertTrue(true, expectedMessage3 + " is present");
			} 
			if (webEl.getText().contains(expectedMessage4)) {
				assertTrue(true, expectedMessage4 + " is present"); 
			}
		}
		else {
			if (!webEl.getText().contains(expectedMessage)) {
				assertTrue(true, expectedMessage + " is present");
			} 
			if (!webEl.getText().contains(expectedMessage2)){
				assertTrue(true, expectedMessage2 + " is present");
			}
			if (!webEl.getText().contains(expectedMessage3)) {
				assertTrue(true, expectedMessage3 + " is present");
			} 
			if (!webEl.getText().contains(expectedMessage4)) {
				assertTrue(true, expectedMessage4 + " is present"); 
			}

		}
	}

	//Method to click on submit button
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}

}

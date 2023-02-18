package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	

	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	//Locators for various page objects
	By webElement = By.xpath("//*[@id='nav-cart']/a/span");
	By emptyCart = By.linkText("Empty Cart");
	By yesEmptyCart = By.linkText("Yes");
	public String verifyCartValues(){
		WebElement webEl =driver.findElement(By.tagName("body"));
		System.out.println(webEl.getText());
		return webEl.getText();
	}
	public String cartCount() {
		String a = driver.findElement(webElement).getText();
		return a;
	}
	public void clickEmptyCart() {
		driver.findElement(emptyCart).click();
	}
	public void clickYesEmptyCart() {
		driver.findElement(yesEmptyCart).click();
	}
}

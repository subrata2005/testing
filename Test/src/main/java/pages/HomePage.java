package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	//Locators for various page objects
	By lnkHome = By.linkText("Home");
	By lnkShop = By.linkText("Shop");
	By lnkContact = By.linkText("Contact");
	By lnkLogin = By.linkText("Login");
	By lnkLogout = By.linkText("Logout");
	By lnkUser = By.linkText("User");
	By lnkCart = By.xpath("//*[@id=\"nav-cart\"]/a");


	public void clickContact() {
		driver.findElement(lnkContact).click();
	}
	public void clickHome() {
		driver.findElement(lnkContact).click();
	}		
	public void clickShop() {
		driver.findElement(lnkShop).click();
	}	
	public void clickCart() {
		driver.findElement(lnkCart).click();
	}
}

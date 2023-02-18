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
		System.out.println("Contact Link is clicked");
	}
	public void clickHome() {
	driver.findElement(lnkContact).click();
	System.out.println("Home Link is clicked");
}		
	public void clickShop() {
		driver.findElement(lnkShop).click();
		System.out.println("Shop Link is clicked");
	}	
	public void clickCart() {
		driver.findElement(lnkCart).click();
		System.out.println("Cart Link is clicked");
	}
}

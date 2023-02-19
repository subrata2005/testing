package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {

	WebDriver driver;
	public ShopPage(WebDriver driver) {
		this.driver=driver;
	}
	//Locators for various page objects
	By lnkFunnyCow = By.xpath("//*[@id=\"product-6\"]/div/p/a");
	By lnkFluffyBunny = By.xpath("//*[@id=\"product-4\"]/div/p/a");
	By lnkStuffedFrog = By.xpath("//*[@id=\"product-2\"]/div/p/a");
	By lnkValentineBear = By.xpath("//*[@id=\"product-7\"]/div/p/a");

	public void buyFunnyCow() {
		driver.findElement(lnkFunnyCow).click();
	}
	public void lnkFluffyBunny() {
		driver.findElement(lnkFluffyBunny).click();
	}
	public void lnkStuffedFrog() {
		driver.findElement(lnkStuffedFrog).click();
	}
	public void lnkValentineBear() {
		driver.findElement(lnkValentineBear).click();
	}
}

package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import org.testng.annotations.*;


public class Testcases extends base {
	
	WebDriver driver;	

	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", getXMLData("chromepath"));
		driver = new ChromeDriver();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(super.getXMLData("testurl"));
		driver.manage().window().maximize();
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase(getXMLData("pagetitle"));
		assertTrue(verifyTitle);
		}

	@Test
	public void test1(){
		HomePage homepage = new HomePage(driver);
		ContactPage contactpage = new ContactPage(driver);
		homepage.clickContact();
		//Clicking the submit button prior to filling the mandatory fields
		contactpage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		contactpage.requiredErrMsg(getXMLData("pageerror"),getXMLData("forenameerror"), getXMLData("emailerror"),getXMLData("messageerror"),true);
		contactpage.dataForename(getXMLData("forename"));
		contactpage.dataEmailField(getXMLData("email"));
		contactpage.dataMessageField(getXMLData("message"));	
		//Check if error messages are removed
		contactpage.requiredErrMsg(getXMLData("pageerror"),getXMLData("forenameerror"), getXMLData("emailerror"),getXMLData("messageerror"),false);
		homepage.clickShop();
		homepage.clickHome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
	}
	
	@Test
	public void test2(){
		HomePage homepage = new HomePage(driver);
		ContactPage contactpage = new ContactPage(driver);
		homepage.clickContact();
		//Filling the mandatory fields & then clicking Submit
		contactpage.dataForename(getXMLData("forename"));
		contactpage.dataEmailField(getXMLData("email"));
		contactpage.dataMessageField(getXMLData("message"));	
		contactpage.clickSubmit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		contactpage.successExists(getXMLData("successmessage")); 
		contactpage.clickBack();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@Test
	public void test3(){
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = new ShopPage(driver);
		CartPage cartpage = new CartPage(driver);
		homepage.clickShop();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		shoppage.buyFunnyCow();	
		shoppage.buyFunnyCow();	
		shoppage.lnkFluffyBunny();
		homepage.clickCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Boolean verify = cartpage.cartCount().contains(getXMLData("countofproducts"));
		assertTrue(verify);
		Boolean verifyCartMsg = (cartpage.verifyCartValues().contains(getXMLData("cartMessage")) && 
				cartpage.verifyCartValues().contains(getXMLData("cartMessage2")) && 
				cartpage.verifyCartValues().contains(getXMLData("cartMessage3")));
		assertTrue(verifyCartMsg);
		cartpage.clickEmptyCart();
		cartpage.clickYesEmptyCart();
	}
	
	@Test
	public void test4(){
		HomePage homepage = new HomePage(driver);
		ShopPage shoppage = new ShopPage(driver);
		CartPage cartpage = new CartPage(driver);
		homepage.clickShop();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		for(int count=1;count<=5;count++){ 
			shoppage.lnkFluffyBunny();	
		}
		for(int count=1;count<=2;count++){ 
			shoppage.lnkStuffedFrog();
		}
		for(int count=1;count<=3;count++){ 
			shoppage.lnkValentineBear();
		}
		homepage.clickCart();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Boolean verify = cartpage.cartCount().contains(getXMLData("countofmultipleproducts"));
		assertTrue(verify);
		float fluffyBunnySubtotal = Float.parseFloat(getXMLData("fluffybunnyprice"))* Integer.parseInt(getXMLData("fluffybunnycount"));
		float valentineBearSubtotal = Float.parseFloat(getXMLData("valentinebearprice"))* Integer.parseInt(getXMLData("valentinebearcount"));
		float stuffForgSubtotal = Float.parseFloat(getXMLData("stufffrogprice"))* Integer.parseInt(getXMLData("stufffrogcount"));
		float netTotal = fluffyBunnySubtotal + valentineBearSubtotal + stuffForgSubtotal;
		Boolean verifyCartMsg = (cartpage.verifyCartValues().contains("Fluffy Bunny $"+getXMLData("fluffybunnyprice")+" $"+String.format("%.2f",fluffyBunnySubtotal)) && 
				cartpage.verifyCartValues().contains("Stuffed Frog $"+getXMLData("stufffrogprice")+" $"+String.format("%.2f",stuffForgSubtotal)) && 
						cartpage.verifyCartValues().contains("Valentine Bear $"+getXMLData("valentinebearprice")+" $"+String.format("%.2f",valentineBearSubtotal))&&
							cartpage.verifyCartValues().contains("Total: "+String.format("%.1f",netTotal)));
		assertTrue(verifyCartMsg);
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}

}

package tests;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.time.Duration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class base {

	WebDriver driver;
	//Reading from XML
	public static String getXMLData(String datafor)
	{
		String nodevalue = null;
		try{

			File file = new File(System.getProperty("user.dir") +"\\properties.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			org.w3c.dom.Document document = documentBuilder.parse(file);
			nodevalue =  document.getElementsByTagName(datafor).item(0).getTextContent();
		}
		catch(Exception e)
		{
			nodevalue = null;
		}
		return nodevalue;
	}
	public void validateString(String actualOutput, String[] errorMsgs, Boolean flag) {
		if (flag == true) {
			for ( String str: errorMsgs) 
			{  
				if (actualOutput.contains(str)) {
					assertTrue(true, str + " is present"); 
				}  
			}
		}
		else {
			for ( String str: errorMsgs) 
			{  
				if (!actualOutput.contains(str)) {
					assertTrue(true, str + " is not present"); 
				} 
			}
		}

	}
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", getXMLData("chromepath"));
		driver = new ChromeDriver();
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(getXMLData("testurl"));
		driver.manage().window().maximize();
		//Verifying if we have invoked the right web app
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase(getXMLData("pagetitle"));
		assertTrue(verifyTitle);
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}

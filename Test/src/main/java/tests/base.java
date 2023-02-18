package tests;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class base {
	
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

}

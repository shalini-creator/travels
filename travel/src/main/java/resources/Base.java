package resources;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {                                                                                                                                                                                                                                                                       

       public WebDriver driver;
		public Properties prop;
	    @Test
		public void Validate() throws Exception {
	    	prop=new Properties();
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver=new ChromeDriver();
			FileInputStream fis=new FileInputStream("C:\\sree\\travel\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			/*driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/a[1]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
			driver.findElement(By.xpath("/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]")).click();
			signup sg=new signup(driver);
	    	sg.signupform();
			
	    	
	    	login lg=new login(driver);
	    	lg.loginform();*/
	    	
	    	/*Hotelsearch hs=new Hotelsearch(driver);
	    	hs.hotels();*/
	    	
	    	toursearch ts=new toursearch(driver);
	    			
	    		ts.tours();
	    			
	    			
	    }
	  
}		 
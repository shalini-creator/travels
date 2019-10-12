package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Hotelsearch extends Base {
	
		WebDriver driver;
		By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
		
		
		
		public Hotelsearch(WebDriver driver) {
			this.driver=driver;
			
	}
		
		By Hotelbtn=By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]");
		By Hotelsname=By.xpath("//div[@id='s2id_location']//a[@class='select2-choice select2-default']");
		By Hotelselect=By.xpath("//div[contains(text(),'chester, United Kingdom')]");
		 
		By checkin=By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");
		By checkout=By.xpath("//input[@placeholder='Check out']");
		By passengers=By.xpath("//input[@id='htravellersInput']");
		By adultbtn=By.xpath("//input[@id='hadultInput']");
		By childbtn=By.xpath("//input[@id='hchildInput']");
		By searchbtn=By.xpath("//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']");
		
		
		public void hotels() throws IOException
		{
			
			 Properties prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\sree\\travel\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			
			driver.findElement(Cookie).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(Hotelbtn).click();
			driver.findElement(Hotelsname).click();
			
			driver.findElement(Hotelsname).sendKeys(prop.getProperty("Hotelsname"));
			driver.findElement(Hotelselect).click();
			
			driver.findElement(checkin).click();
			while(!driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
			{driver.findElement(By.xpath("//div[14]//div[1]//tr[1]//th[3]")).click();
			
			}
			int count=driver.findElements(By.className("day")).size();
			for(int i=0;i<count;i++)
			{
				String text=driver.findElements(By.className("day")).get(i).getText();
				if(text.equalsIgnoreCase("29"))
				{
					driver.findElements(By.className("day")).get(i).click();
				}
				
			}
				driver.findElement(checkout).click();
				int count1=driver.findElements(By.className("day")).size();
				for(int i=0;i<count1;i++)
				{
					String text=driver.findElements(By.className("day")).get(i).getText();
					if(text.equalsIgnoreCase("13"))
					{
						driver.findElements(By.className("day")).get(i).click();
					}
				}
					driver.findElement(passengers).click();
					driver.findElement(adultbtn).clear();
					driver.findElement(adultbtn).sendKeys("2");
					driver.findElement(childbtn).clear();
					driver.findElement(childbtn).sendKeys("3");
					driver.findElement(searchbtn).click();
					
					
				
				
				
			}
			
				
			}
		

			
			
		
			
			
		
		
		
		
		
		


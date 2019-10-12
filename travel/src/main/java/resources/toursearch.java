package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class toursearch extends Base {
	WebDriver driver;
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	
	public toursearch(WebDriver driver) {
		this.driver=driver;
		
}
	By toursbtn=By.xpath("//div[@id='body-section']//li[3]//a[1]");
	By toursname=By.xpath("//div[@id='s2id_autogen3']//a[@class='select2-choice select2-default']");
	By tourselect=By.xpath("//div[contains(text(),'raton Trip')]");
	By date=By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]");
	By guests=By.xpath("//select[@id='adults']");
	By typeoftour=By.xpath("//select[@id='tourtype']");
	By typeoftour1=By.xpath("//option[contains(text(),'Couples')]");
	 By searchbtn=By.xpath("/html[1]/body[1]/div[6]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/button[1]");


	public void tours() throws IOException
	{
		
		 Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\sree\\travel\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(toursbtn).click();
		driver.findElement(toursname).click();
		
		driver.findElement(toursname).sendKeys(prop.getProperty("toursname"));
		driver.findElement(tourselect).click();
		
		driver.findElement(date).click();
		while(!driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[2]")).getText().contains("November 2019"))
		{driver.findElement(By.xpath("//div[11]//div[1]//tr[1]//th[3]")).click();
		
		}
		int count=driver.findElements(By.className("day")).size();
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("20"))
			{
				driver.findElements(By.className("day")).get(i).click();
			}
			
		}
		driver.findElement(guests).click();
		driver.findElement(By.xpath("//select[@id='adults']//option[4]")).click();
		driver.findElement(typeoftour).click();
		driver.findElement(typeoftour1).click();
		driver.findElement(searchbtn).click();
		
	}
}
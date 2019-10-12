package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login  extends Base{
	WebDriver driver;
	Properties prop;
	public login (WebDriver driver) {
this.driver=driver;
		
	}
	By Email=By.xpath("//input[@placeholder='Email']");
	By Password=By.xpath("//input[@placeholder='Password']");
	By Cookie = By.xpath("//button[@id='cookyGotItBtn']");
	By loginbtn = By.xpath("//button[@class='btn btn-action btn-lg btn-block loginbtn']");
	
	public void loginform() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\sree\\travel\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(Email).sendKeys(prop.getProperty("Email"));
		driver.findElement(Password).sendKeys(prop.getProperty("Password"));
		driver.findElement(loginbtn).click();
		
	}

}



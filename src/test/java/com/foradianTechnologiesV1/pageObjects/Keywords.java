package com.foradianTechnologiesV1.pageObjects;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

//	static FirefoxDriver driver;

	static ChromeDriver driver;
   // System.setProperty("webdriver.chrome.driver", "/home/foradian/App/chromedriver");

	static Properties prop;
	static FileInputStream file;
	
	public void openbrowser() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "/home/foradian/App/chromedriver");

		driver = new ChromeDriver();
		
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		file=new FileInputStream("/home/foradian/eclipse-workspace/foradianTechnologiesV2/src/test/java/com/foradianTechnologiesV1/pageObjects/Objectrepository.properties");
		prop=new Properties();
		prop.load(file);
	}
	
	
	public void navigate(String Data) {
		
		driver.manage().window().maximize();
		driver.get(Data);
	}
	

	public void input(String Data, String ObjectName)  {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty(ObjectName))).sendKeys(Data);
		
	}
	
	public void inputint(String Data, String ObjectName)  {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty(ObjectName))).sendKeys(Data);
		
	}
	

	public void inputintwithchar(CharSequence Data, String ObjectName)  {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty(ObjectName))).sendKeys(Data);
		
	}
	
	
	public void click(String ObjectName) throws Exception {
		
		//driver.findElement(By.xpath("//*[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(prop.getProperty(ObjectName))).click();
		
		
	}
	
	/* 
	 public void select(String ObjectName,int Data) throws Exception{
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
	Select select=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
	select.selectByIndex(Data);
	}
*/


	public void select(String ObjectName, int Data) throws Exception {
		// TODO Auto-generated method stub
		
		Select select=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
		//select.selectByValue(Data);		
		select.selectByIndex(Data);		
	//driver.manage().timeouts().implicitlyWait(time, unit)
		
	}
	
	public void sleep(String ObjectName, int Data) throws Exception {
		System.out.println("\n\n\n\n\n\n  time : " + Data);
		Thread.sleep(Data);
		
	}
	
	public void selectbyindex(String ObjectName, int Data) throws Exception {
		// TODO Auto-generated method stub	
		
		Select selectDobMonth=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
		//selectDobMonth.selectByValue(Data);
		System.out.println("\n\n\n\n\n\n  time : " + Data);
		selectDobMonth.selectByIndex(Data);
		//se.selectByIndex(Integer.parseInt(Data));		
	//driver.manage().timeouts().implicitlyWait(time, unit)
		
	}
	
	
	
	public void selectbyvisibletextstring(String ObjectName, String Data) throws Exception {
		// TODO Auto-generated method stub
		
		Select selectDobMonth=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
		selectDobMonth.selectByVisibleText(Data);
		System.out.println("\n\n\n\n\n Class name of object: "+Data.getClass().getName());
	//	selectDobMonth.selectByIndex(Data);
		//se.selectByIndex(Integer.parseInt(Data));

		
	//driver.manage().timeouts().implicitlyWait(time, unit)
		
	}
	
	
	public void selectbyvisibletextint(String ObjectName, String Data) throws Exception {
		// TODO Auto-generated method stub
		
		Select selectDobMonth=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
		selectDobMonth.selectByVisibleText(Data);
	//	System.out.println("\n\n\n\n\n Class name of object: "+Data.getClass().getName());
	//	selectDobMonth.selectByIndex(Data);
		//se.selectByIndex(Integer.parseInt(Data));

		
	//driver.manage().timeouts().implicitlyWait(time, unit)
		
	}
	
	
	
	
	
	
	
	public void selectbyvalue(String ObjectName, String Data) throws Exception {
		// TODO Auto-generated method stub
		
		Select selectDobMonth=new Select(driver.findElement(By.xpath(prop.getProperty(ObjectName))));
	/*
	 * public void dobcalendarbyvalue(String ObjectName, int data) Exception
	geting the value of methods'sint data and converting it into string here		
	selectDobMonth.selectByValue(String.valueOf(data));		
		*/		
		selectDobMonth.selectByValue(Data);		
	//	selectDobMonth.selectByIndex(Data);
		//se.selectByIndex(Integer.parseInt(Data));

		
	//driver.manage().timeouts().implicitlyWait(time, unit)
		
	}
	
	public void robotclick(String ObjectName) throws Exception {
		
		//driver.findElement(By.xpath("//*[@id='Login']")).click();
		//driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath(ObjectName)).click();
		Thread.sleep(1000);		
		
	}
	
	public void robot(String ObjectName, String Data) throws Exception {
		// TODO Auto-generated method stub
		
		//driver.findElement(By.id(ObjectName)).click();
		//Thread.sleep(2000);
		 
		StringSelection selection=new StringSelection(Data);
		   	
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
            Thread.sleep(2000);
            //ctrl+v and Enter
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		Thread.sleep(2000);
		
	}
	
	 
	
	
	
	

	
	
}


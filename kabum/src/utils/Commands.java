package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Commands{
	
	public void click(WebDriver driver, By by) throws Exception{
		driver.findElement(by).click();
	}
	
	public void insertText(WebDriver driver, By by, String texto) throws Exception {
		driver.findElement(by).clear();
		Thread.sleep(2000);
		driver.findElement(by).sendKeys(texto);
		driver.findElement(by).click();
	}
	
	public void navigate(WebDriver driver, String url) throws Exception {
		driver.get(url);
	}
	
	public void pressKey(WebDriver driver,Keys key) throws Exception{
		Actions action = new Actions(driver);
	    action.sendKeys(key).build().perform();
	}
	
	public void selectComboBox(WebDriver driver, By by, String value) throws Exception{
		new Select(driver.findElement(by)).selectByVisibleText(value);
	}
	
	public WebElement element(WebDriver driver, By by) throws Exception{ 
		return driver.findElement(by);
	}
	
	public void moveToElement(WebDriver driver, By by){
		WebElement element = driver.findElement(by);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public boolean isDisplayed(WebDriver driver, By by){
		return driver.findElement(by).isDisplayed();
	}

}

package com.Maven_Cucumber;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static WebDriver driver;

	// 1.launchbrowser
	public static WebDriver launchbrowser(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		return driver;
	}

	// 2.get
	public static void launchUrl(String url){
		driver.get(url);
	}
    
	// 3.navigate to forward

	public static void forwardpage() {
		driver.navigate().forward();
	}

	// 4.Navigate TO
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}

	// 5.Navigate-back
	public static void backPage(WebElement element) {
		driver.navigate().back();
	}

	// 6.Navigate-Refresh
	public static void reFresh(WebElement element) {
		driver.navigate().refresh();
	}

	// 7.RadioButton
	public static void RadioButton(WebElement element) {
		element.click();
	}

	// 8.close
	public static void close() {
		driver.close();
	}

	// 9.quit
	public static void quit() {
		driver.quit();
	}

	// 10.send keys
	public static void passinput(WebElement element, String input) {
		element.sendKeys(input);
	}

	// 11.click
	public static void click(WebElement element) {
		element.click();
	}

	// 12.clear
	public static void clear(WebElement element) {
		element.clear();
	}

	private static Select dropdownobject(WebElement element) {
		Select s = new Select(element);
		return s;
	}

	// 13.select by value
	public static void selectbyvalue(WebElement element, String ind) {
		dropdownobject(element).selectByValue(ind);
	}

	// 14.select by index
	public static void selectbyindex(WebElement element, int input) {
		dropdownobject(element).selectByIndex(input);
	}

	// 15.select by visible text
	public static void selectbyvisibletext(WebElement element, String sec) {
		dropdownobject(element).selectByVisibleText(sec);
	}

	// 16.Takescreenshot
	public static void Takescreenshot(String loc) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(null);
		FileUtils.copyDirectory(src, new File("loc"));
	}

	// 17.Full Takescreenshot
	public static void full_Takescreenshot() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("path"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// 18. scroll up and down
	public static void scroll(String src, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) element;
		js.executeAsyncScript(src, element);
	}

	// 19. Alert Accept
	public static void aleraccept() {
		Alert a = driver.switchTo().alert();

	}

	// 20. Alert dismiss
	public static void alertdismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 21.Alert send keys
	public static void alertsendkeys() {
		Alert a = driver.switchTo().alert();
		a.sendKeys(null);
	}

	// 22.Alert Get text
	public static void gettext() {
		Alert a = driver.switchTo().alert();
		a.getText();
		// syso
	}

	// 23.Get url
	public static void geturl() {
		System.out.println(driver.getCurrentUrl());
	}

	// 24.Get title
	public static void gettitle() {
		System.out.println(driver.getTitle());
	}

	// 25.Get text
	public static void gettext(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	private static Actions Actionsobj() {
		Actions ac = new Actions(driver);
		return ac;
	}

	// 26.Actions click
	public static void actionsclick(WebElement element) {
		Actionsobj().click(element).perform();
	}

	// 27.Actions contextclick
	public static void actionscontextclick(WebElement element) {
		Actionsobj().contextClick(element).perform();
	}

	// 28.Actions Doubleclick
	public static void actionsdoubleclick(WebElement element) {
		Actionsobj().doubleClick(element).perform();
	}

	// 29.Actions Draganddrop
	public static void actionsdraganddrop(WebElement element, WebElement element2) {
		Actionsobj().dragAndDrop(element, element2).click().build().perform();
	}

	private static Robot robotobj() throws AWTException {
		Robot r = new Robot();
		return r;
	}

	// 30.robot up keypress
	public static void upkeypress() throws Throwable {
		robotobj().keyPress(KeyEvent.VK_UP);
		robotobj().keyRelease(KeyEvent.VK_UP);
	}

	// 31.robot downkeypress
	public static void downkeypress() throws Throwable {
		robotobj().keyPress(KeyEvent.VK_DOWN);
		robotobj().keyPress(KeyEvent.VK_DOWN);
	}

	// 32.robot Enter
	public static void robotenter() throws Throwable {
		robotobj().keyPress(KeyEvent.VK_ENTER);
		robotobj().keyRelease(KeyEvent.VK_ENTER);
	}

	// 33.get window handles
	public static void windowhandles() {
		Set<String> str = driver.getWindowHandles();
		System.out.println(str);
		for (String id : str) {
			String name = driver.switchTo().window(id).getTitle();
			System.out.println(name);
		}
	}

	// 34.get window handle
	public static void windowhandle() {
		String id = driver.getWindowHandle();
		System.out.println(id);
	}

	// 35.isenable
	public static void isenable(WebElement element) {
		System.out.println(element.isEnabled());
	}

	// 36.isdisable
	public static void isdisable(WebElement element) {
		System.out.println(element.isDisplayed());
	}

	// 37.isselected
	public static void isiselected(WebElement element) {
		System.out.println(element.isSelected());
	}

	// 38.deselect by visible text
	public static void delselectedbyvisibletext(WebElement element, String des) {
		dropdownobject(element).deselectByVisibleText(des);
	}

	// 39.deselect by value
	public static void deselectbyvalue(WebElement element, String text) {
		dropdownobject(element).deselectByValue(text);
	}

	// 40.deselect by index
	public static void deselectbyindex(WebElement element, Integer ind) {
		dropdownobject(element).deselectByIndex(ind);
	}

	// 41.ismultiple
	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.isMultiple());
	}

	// 42.get option
	public static void getoption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement set : options) {
			System.out.println(set.getText());
		}
	}

	// 43. get all selected option
	public static void getallselectedoption(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allselectedoption = s.getAllSelectedOptions();
		for (WebElement allset : allselectedoption) {
			System.out.println(allset.getText());
		}
	}

	// 44. get first selected option
	public static void getfirstselectedoption(WebElement element) {
		Select s = new Select(element);
		WebElement firstset = s.getFirstSelectedOption();
		System.out.println(firstset.getText());
	}

	// 45.wait[implicity]
	public static void implicitywait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// 46.Explicity wait
	public static void explicitwait(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// 47.fluent wait
	public static void fluentwait(int sec) {
		FluentWait w = new FluentWait(driver);
		w.withTimeout(sec, TimeUnit.SECONDS);
		w.pollingEvery(sec, TimeUnit.SECONDS);
		w.ignoring(Exception.class);
	}

	// 48. web-table alldatas
	public static void webtablealldatas(List<WebElement> elements) {
		List<WebElement> datas = elements;
		for (WebElement alldatas : datas) {
			System.out.println(alldatas.getText());
		}
	}

	// 49. web-table row
	public static void allrow(List<WebElement> elements) {
		List<WebElement> rdatas = elements;
		for (WebElement rowdatas : rdatas) {
			System.out.println(rowdatas.getText());
		}
	}

	// 50. web-table columns
	public static void columns(List<WebElement> elements) {
		List<WebElement> col = elements;
		for (WebElement columns : col) {
			System.out.println(columns.getText());
		}
	}

	// 51.web-table singledata
	public static void singledata(WebElement element) {
		System.out.println(element.getText());
	}

	// 52.frameid
	public static void frameid(String id) {
		driver.switchTo().frame(id);
	}

	// 53.frame index
	public static void frameindex(int index) {
		driver.switchTo().frame(index);
	}

	// 54.frame webelement
	public static void framewebelemnt(WebElement element) {
		driver.switchTo().frame(element);
	}

	// 55.frame exit
	public static void frameexit() {
		driver.switchTo().defaultContent();
	}

	// 56.outer frame
	public static void outerframe() {
		driver.switchTo().parentFrame();
	}
}

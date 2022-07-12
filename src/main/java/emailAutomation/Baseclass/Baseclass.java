package emailAutomation.Baseclass;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.Scenario;

public class Baseclass {

	public static Properties Prop;
	public static String Locator;
	public static File FileLocation;
//	public static String LocatorValue;
	public static AndroidDriver<AndroidElement> AndroidDriver;
	
	
	public static String LocatorPropertiesFile = "./src/test/resources/Properties/Xpath.properties" ;
	public static  String AppPropertiesFile = "./src/test/resources/Properties/App.properties" ;
	

	public String ReadProperties(String Property, String Location) throws Throwable {

		Prop = new Properties();
		File FileLocation = new File(Location);
		FileReader ReadFile = new FileReader(FileLocation);
		Prop.load(ReadFile);
		return	Prop.getProperty(Property);
	}
	
	public void LaunchApp() throws Throwable {
		
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.UDID, ReadProperties("App.UDID", AppPropertiesFile));
		DC.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ReadProperties("APP.PACKAGE", AppPropertiesFile));
		DC.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ReadProperties("APP.ACTIVITY", AppPropertiesFile));
		AndroidDriver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), DC);
	
	}


	public void PrintValue(String Value) {

		System.out.println(Value);
	}

	public void PrintError(String Value) {

		System.err.println(Value);
	}

	public WebElement GetElement(String Property, String Location) throws Throwable {

		String LocatorType, LocatorValue;
		Properties Prop = new Properties();
		FileLocation = new File(Location);
		FileReader File = new FileReader(FileLocation);
		Prop.load(File);		
		LocatorType = Prop.getProperty(Property).split(" ")[0];
		LocatorValue = Prop.getProperty(Property).split(" ")[1];

		switch (LocatorType) {
		case "id":
			WebDriverWait id = new WebDriverWait(AndroidDriver, 120);
			return	id.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.id(LocatorValue))));

		case "xpath":
			WebDriverWait xpath = new WebDriverWait(AndroidDriver, 120);
			return	xpath.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.xpath(LocatorValue))));
		case "css":
			WebDriverWait css = new WebDriverWait(AndroidDriver, 120);
			return	css.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.cssSelector(LocatorValue))));
		case "tag":
			WebDriverWait tag = new WebDriverWait(AndroidDriver, 120);
			return	tag.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.tagName(LocatorValue))));
		case "partialText":
			WebDriverWait partialText = new WebDriverWait(AndroidDriver, 120);
			return	partialText.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.partialLinkText(LocatorValue))));
		case "linkText":
			WebDriverWait linkText = new WebDriverWait(AndroidDriver, 120);
			return	linkText.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.linkText(LocatorValue))));
		case "name":
			WebDriverWait name = new WebDriverWait(AndroidDriver, 120);
			return	name.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.name(LocatorValue))));
		case "className":
			WebDriverWait className = new WebDriverWait(AndroidDriver, 120);
			return	className.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.className(LocatorValue))));



		default:
			WebDriverWait defaultvalue = new WebDriverWait(AndroidDriver, 120);
			return	defaultvalue.until(ExpectedConditions.elementToBeClickable(AndroidDriver.findElement(By.xpath(LocatorValue))));

		}
	}

	public WebElement WaitForTheElement(String LoadXpath) throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(AndroidDriver, 20);
		WebElement Element= 	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoadXpath)));
		return Element;
	}
	
	public void ClickElement(String Locator,String locatorfile ) throws Throwable {

		WebDriverWait wait = new WebDriverWait(AndroidDriver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(GetElement(Locator,locatorfile))).click();

	}
	
	public  void ForceClick(String Locator,String locatorfile ) throws Throwable {
		WebElement element = GetElement(Locator, locatorfile);
		JavascriptExecutor executor = (JavascriptExecutor)AndroidDriver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void TypeDataInTheField ( String Locator,String locatorfile, String Data) throws Throwable {

		WebDriverWait wait = new WebDriverWait(AndroidDriver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(GetElement(Locator,locatorfile)));
		Element.sendKeys(Data);
		
	} 
	
	public String GetText ( String Locator,String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(AndroidDriver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(GetElement(Locator,locatorfile)));
		return Element.getText();
	} 
	
	public static boolean IsEqual(String ActualValue, String ExpectedValue ) throws Throwable {

		return ActualValue.equalsIgnoreCase(ExpectedValue);

	}
	
	public boolean IsElementDisplayed ( String Locator,String locatorfile) throws Throwable {

		WebDriverWait wait = new WebDriverWait(AndroidDriver, 120);
		WebElement Element =	wait.until(ExpectedConditions.elementToBeClickable(GetElement(Locator,locatorfile)));
		return Element.isDisplayed();
	} 

	public void ScrollElement(String visibleText) {

		String scrollElement =	"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+ visibleText + "\").instance(0))";
		AndroidDriver.findElementByAndroidUIAutomator(scrollElement);

	}

	public void ScrollToElement(String Xpath, String Direction) {

		JavascriptExecutor js = (JavascriptExecutor) AndroidDriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", Direction);
		scrollObject.put("xpath", Xpath);
		js.executeScript("mobile: scroll", scrollObject);

	}
	public void Enter() {
	((AndroidDriver) AndroidDriver).pressKey(new KeyEvent(AndroidKey.ENTER));

	}
}

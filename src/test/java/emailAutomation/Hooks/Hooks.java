package emailAutomation.Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import emailAutomation.Baseclass.Baseclass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass{

	@AfterStep()
	public void ScreenShot(Scenario scenario) throws Throwable {

		final byte[] screenshot = AndroidDriver.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Refer the Screenshot"); 

	}

}

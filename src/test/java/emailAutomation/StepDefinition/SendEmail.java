package emailAutomation.StepDefinition;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import emailAutomation.Baseclass.Baseclass;
import emailAutomation.ExcelRead.ExcelRead;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class SendEmail extends Baseclass {



	@Given("User opens the app")
	public void user_opens_the_app()  throws Throwable {

		try {

			LaunchApp();

			PrintValue("Execution Started");

			if (IsElementDisplayed("Email.NewMessage", LocatorPropertiesFile)) {
				PrintValue("Application Launched Successfully");
				ExtentCucumberAdapter.addTestStepLog("Application Launched Successfully");
			}
		} 
		catch (Exception e) {
			PrintError("Application Launched Failed");
			ExtentCucumberAdapter.addTestStepLog("Application Launched Failed");
		}
	}

	@Given("compose an email")
	public void compose_an_email() throws Throwable {

		try {
			ClickElement("Email.NewMessage", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("New message button is clicked");
			PrintValue("New message button is clicked");

			String EmailID =	ExcelRead.ReadExcelFile(1, 0, ExcelRead.MailContent);
			TypeDataInTheField("Email.To", LocatorPropertiesFile, EmailID );
			ExtentCucumberAdapter.addTestStepLog("Entered MailID: " + EmailID);
			PrintValue("Entered MailID: " + EmailID);

			String Subject =	ExcelRead.ReadExcelFile(1, 1, ExcelRead.MailContent);
			TypeDataInTheField("Email.Subject", LocatorPropertiesFile, Subject );
			ExtentCucumberAdapter.addTestStepLog("Entered Subject: " + Subject);
			PrintValue("Entered Subject: " + Subject);	

			String Body =	ExcelRead.ReadExcelFile(1, 2, ExcelRead.MailContent);
			TypeDataInTheField("Email.Content", LocatorPropertiesFile, Body );
			ExtentCucumberAdapter.addTestStepLog("Entered Body: " + Body);
			PrintValue("Entered Body: " + Body);
		}
		catch (Exception e) {
			PrintError(e.getMessage());
			PrintError("Email content is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email content is not filled");
		}
	}

	@And("save it as draft")
	public void save_it_as_draft() throws Throwable {


		try {

			ClickElement("Email.Close", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("Close button is clicked");
			PrintValue("Close button is clicked");

		} catch (Exception e) {
			PrintError(e.getMessage());
			PrintError("Close button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Close button is not clicked");
		}

	}

	@Then("validate the draft")
	public void validate_the_draft() {


	}

	@Given("User clicks profile")
	public void user_clicks_profile() throws Throwable {

		try {

			ClickElement("Email.Profile", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("Profile button is clicked");
			PrintValue("Profile button is clicked");

		} catch (Exception e) {
			PrintError(e.getMessage());
			PrintError("Profile button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Profile button is not clicked");
		}

	}

	@And("Opens the draft section from the menu")
	public void opens_the_draft_section_from_the_menu() throws Throwable {

		try {

			ClickElement("Email.Draft", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("Draft button is clicked");
			PrintValue("Draft button is clicked");

			if (IsElementDisplayed("Email.Draftsubject", LocatorPropertiesFile)) {
				PrintValue("Draft section is opened");
				ExtentCucumberAdapter.addTestStepLog("Draft section is opened");
			}
		} catch (Exception e) {
			PrintError(e.getMessage());
			PrintError("Draft section is not opened");
			ExtentCucumberAdapter.addTestStepLog("Draft section is not opened");
		}

	}

	@Given("Selects the mail")
	public void selects_the_mail() throws Throwable {

		try {
			String Subject =	ExcelRead.ReadExcelFile(1, 1, ExcelRead.MailContent);
			String DraftSubject =	GetText("Email.Draftsubject", LocatorPropertiesFile);
			if (IsEqual(DraftSubject, Subject)) {

				ClickElement("Email.Draftsubject", LocatorPropertiesFile);
				ExtentCucumberAdapter.addTestStepLog("Mail is selected");
				PrintValue("Mail is selected");
			}


		} catch (Exception e) {
			PrintError(e.getMessage());
			PrintError("Mail is not selected");
			ExtentCucumberAdapter.addTestStepLog("Mail is not selected");
		}
	}


	@Then("send the email")
	public void send_the_email() throws Throwable {

		try {

			ClickElement("Email.SendEmail", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("Send button is clicked");
			PrintValue("Send button is clicked");

		} catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Send button is not clicked");
			PrintError("Send button is not clicked");
		}
	}


	@And("Selects inbox")
	public void selects_inbox() throws Throwable {

		try {

			ClickElement("Email.Inbox", LocatorPropertiesFile);
			ExtentCucumberAdapter.addTestStepLog("Inbox button is clicked");
			PrintValue("Inbox button is clicked");

			if (IsElementDisplayed("Email.NewMessage", LocatorPropertiesFile)) {
				PrintValue("Inbox section is opened");
				ExtentCucumberAdapter.addTestStepLog("Inbox section is opened");
			}

		} catch (Exception e) {

			PrintError(e.getMessage());
			PrintError("Inbox section is not opened");
			ExtentCucumberAdapter.addTestStepLog("Inbox section is not opened");
		}

	} 


	@Then("swipe to archive an email")
	public void swipe_to_archive_an_email() throws Throwable {

		try {

			String Archive =	ExcelRead.ReadExcelFile(1, 3, ExcelRead.MailContent);

			String ArchiveEmail =	GetText("Email.ArchiveEmail", LocatorPropertiesFile);
			if (IsEqual(Archive, ArchiveEmail)) {
				ScrollToElement(Archive, "right");
				ExtentCucumberAdapter.addTestStepLog("Mail swiped to archive");
				PrintValue("Mail swiped to archive");
			}

		} catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Archive action failed");
			PrintError("Archive action failed");
		}
	}

}

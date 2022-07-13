package emailAutomation.StepDefinition;

import emailAutomation.Baseclass.Baseclass;
import emailAutomation.Methods.SendEmailMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class SendEmail extends Baseclass {



	@Given("User opens the app")
	public void user_opens_the_app()  throws Throwable {

		SendEmailMethods.OpenApp();
	}

	@Given("Compose an email")
	public void compose_an_email() throws Throwable {

		SendEmailMethods.ComposeEmail();
	}

	@Then("Save it as draft")
	public void save_it_as_draft() throws Throwable {

		SendEmailMethods.SaveDraft();

	}


	@Given("User clicks profile")
	public void user_clicks_profile() throws Throwable {

		SendEmailMethods.ClickProfile();

	}

	@And("Opens the draft section from the menu")
	public void opens_the_draft_section_from_the_menu() throws Throwable {

		SendEmailMethods.OpenDraftSection();

	}

	@Given("Selects the mail")
	public void selects_the_mail() throws Throwable {

		SendEmailMethods.SelectMailFromDraft();
	}


	@Then("Send the email")
	public void send_the_email() throws Throwable {

		SendEmailMethods.SendMailFromDraft();
	}


	@And("Clicks inbox")
	public void selects_inbox() throws Throwable {

		SendEmailMethods.ClickInbox();

	} 


	@Then("Swipe to archive an email")
	public void swipe_to_archive_an_email() throws Throwable {

		SendEmailMethods.SwipeMailToArchive();
	}

}

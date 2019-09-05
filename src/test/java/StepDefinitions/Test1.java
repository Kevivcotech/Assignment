package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import Pages.Page;

public class Test1 {
	
	@Given("^Navigate to https://go.discovery.com/$")
	  public void Navigate_To_Link() throws Throwable {
		Page.NavigateURL();
	  }

	@And("^Scroll down to popular shows$")
	  public void Scroll_Down_Popular_Shows() throws Throwable {
		Page.ScrollDown();
	  }
	
	@And("^Go to the last video by pressing the icon '>'$")
	  public void Goto_Last_Video() throws Throwable {
		Page.ClickOnArrowTillLastVideo();
	  }
	
	@Then("^Click on EXPLORE THE SHOW for last video$")
	  public void Click_Explore_Show_Button() throws Throwable {
		Page.ClickOnExploreShowButton();
	  }
	
	@And("^Click on SHOW MORE until its visible$")
	  public void Click_ShowMore_Button() throws Throwable {
		Page.ClickOnShowMoreButton();
	  }
	
	@Then("^Create a new file and write all the show titles and duration into it$")
	  public void Extract_Title_Duration_And_Save_In_New_File() throws Throwable {
		Page.ExtractTitleAndDurationAndSaveInNewFile();
	  }
	
	@And("^Close the browser$")
	  public void Close_Browser() throws Throwable{
		  Page.CloseBrowser();
	  }
	

}

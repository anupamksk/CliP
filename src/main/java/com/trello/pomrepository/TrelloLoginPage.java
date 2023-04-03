package com.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	
	WebDriver driver;
	
	public TrelloLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user")
	private WebElement usernameTextField;
	
	@FindBy(id = "login")
	private WebElement continueButton;
		
	@FindBy(xpath = "//span[text()='Continue with Google']")
	private WebElement continueWithGoogleLink;
	
	@FindBy(xpath = "//span[text()='Continue with Microsoft']")
	private WebElement continueWithMicrosoftLink;
	
	@FindBy(xpath = "//span[text()='Continue with Apple']")
	private WebElement continueWithAppleLink;
	
	@FindBy(xpath = "//span[text()='Continue with Slack']")
	private WebElement continueWithSlackLink;
	
	@FindBy(linkText = "Log in with SSO")
	private WebElement loginWithSSQLink;
	
	@FindBy(linkText = "Can't log in?")
	private WebElement CantLoginLinkText;
	
	@FindBy(linkText = "Sign up for an account")
	private WebElement signUpForAnAccountLinkText;
	
	@FindBy(linkText = "Privacy Policy")
	private WebElement privacyPolicyLinkText;
	
	@FindBy(linkText = "Terms of Service")
	private WebElement termsOfServiceLinkText;
	
	@FindBy(id = "language-picker")
	private WebElement langaugePickerDropDown;
	
	@FindBy(linkText = "Templates")
	private WebElement templatesLinkText;
	
	@FindBy(linkText = "Pricing")
	private WebElement pricingLinkText;
	
	@FindBy(linkText = "Apps")
	private WebElement appsLinkText;
	
	@FindBy(linkText = "Jobs")
	private WebElement jobsLinkText;

	@FindBy(linkText = "Blog")
	private WebElement blogLinkText;

	@FindBy(linkText = "Developers")
	private WebElement developersLinkText;
	
	@FindBy(linkText = "Help")
	private WebElement helpLinkText;
	
	@FindBy(linkText = "Cookie Settings")
	private WebElement cookieSettingsLinkText;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getContinueWithGoogleLink() {
		return continueWithGoogleLink;
	}

	public WebElement getContinueWithMicrosoftLink() {
		return continueWithMicrosoftLink;
	}

	public WebElement getContinueWithAppleLink() {
		return continueWithAppleLink;
	}

	public WebElement getContinueWithSlackLink() {
		return continueWithSlackLink;
	}

	public WebElement getLoginWithSSQLink() {
		return loginWithSSQLink;
	}

	public WebElement getCantLoginLinkText() {
		return CantLoginLinkText;
	}

	public WebElement getSignUpForAnAccountLinkText() {
		return signUpForAnAccountLinkText;
	}

	public WebElement getPrivacyPolicyLinkText() {
		return privacyPolicyLinkText;
	}

	public WebElement getTermsOfServiceLinkText() {
		return termsOfServiceLinkText;
	}

	public WebElement getLangaugePickerDropDown() {
		return langaugePickerDropDown;
	}

	public WebElement getTemplatesLinkText() {
		return templatesLinkText;
	}

	public WebElement getPricingLinkText() {
		return pricingLinkText;
	}

	public WebElement getAppsLinkText() {
		return appsLinkText;
	}

	public WebElement getJobsLinkText() {
		return jobsLinkText;
	}

	public WebElement getBlogLinkText() {
		return blogLinkText;
	}

	public WebElement getDevelopersLinkText() {
		return developersLinkText;
	}

	public WebElement getHelpLinkText() {
		return helpLinkText;
	}

	public WebElement getCookieSettingsLinkText() {
		return cookieSettingsLinkText;
	}
	
	
	
}

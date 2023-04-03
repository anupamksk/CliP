package trello;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.trello.pomrepository.LogoutOfAtlassianAccountPage;
import com.trello.pomrepository.TrelloAccountBoardPage;
import com.trello.pomrepository.TrelloCreatedBoardPage;
import com.trello.pomrepository.TrelloHomePage;
import com.trello.pomrepository.TrelloLoginPage;
import com.trello.pomrepository.TrelloLoginToContinuePage;

import genericutility.BaseClass;

public class TrelloTestCaseExecution extends BaseClass {
	@Test(priority = 1)
	public void homepageCheck() throws EncryptedDocumentException, IOException, TimeoutException {
		// Validating Title
		String completeHomepageTitle = excelutil.readStringData("trellotestcasedata", 3, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeHomepageTitle), true,
				"Trello home page is not displayed and verified upon title.");
		Reporter.log("Trello home page is displayed and verified upon title.");
		// Validating URL
		String completeHomepageUrl = fileUtil.readCommondata("url");
		Assert.assertEquals(webdriverUtil.explicitwaitForCompleteUrl(driver, completeHomepageUrl), true,
				"Trello home page is not displayed and verified upon url.");
		Reporter.log("Trello home page is displayed and verified upon url.");
	}

	@Test(priority = 2)
	public void loginpageCheck() throws EncryptedDocumentException, IOException, TimeoutException {
		// clicking on Login button
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		// Validating Title
		String completeLoginpageTitle = excelutil.readStringData("trellotestcasedata", 4, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginpageTitle), true,
				"Trello login page is not displayed and verified upon title.");
		Reporter.log("Trello login page is displayed and verified upon title.");
		// validating URL
		String completeLoginpageUrl = excelutil.readStringData("trellotestcasedata", 5, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForCompleteUrl(driver, completeLoginpageUrl), true,
				"Trello login page is not displayed and verified upon url.");
		Reporter.log("Trello login page is displayed and verified upon url.");
	}
	@Test(priority = 3)
	public void loginToAccount() throws Throwable {
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		logout();
	}

	@Test(priority = 4)
	public void createAndDeleteBoard() throws Throwable {
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelutil.readStringData("trellotestcasedata", 2, 1));
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdpage = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdpage.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===============================================================================
		// Delete The board
		// ===============================================================================
		deleteBoard();
		logout();
	}

	public void deleteBoard() throws Throwable {
		TrelloCreatedBoardPage createdpage1 = new TrelloCreatedBoardPage(driver);
		// Checking for Board Menu Pop-up
		webElementUtil.clickOnVisibleElement(driver, createdpage1.boardMenubar());
		Assert.assertTrue(webElementUtil.displayOfElement(driver, createdpage1.moreOptionInBoardMenu()),
				"Board menu is not displyed");
		webElementUtil.clickOnVisibleElement(driver, createdpage1.moreOptionInBoardMenu());
		webElementUtil.clickOnVisibleElement(driver, createdpage1.closeBoardOptionInMore());
		webElementUtil.clickOnVisibleElement(driver, createdpage1.confirmCloseButton());
		webElementUtil.clickOnVisibleElement(driver, createdpage1.permenentlyDeleteBoardLink());
		webElementUtil.clickOnVisibleElement(driver, createdpage1.confirmPermenentlyDeleteButton());
		// Validating Board Deleted Pop-up
		Assert.assertTrue(webElementUtil.displayOfElement(driver, createdpage1.boardDeletedConfirmationPopup()),
				"Board is not deleted and board deleted popup is not displayed");
		Reporter.log("Board is succefully deleted and varified on popup displayed");
	}

	@Test (priority = 5)
	public void create2ListsInBoard() throws Throwable {
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelutil.readStringData("trellotestcasedata", 2, 1));
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create 2 list in the board
		// ===================================================
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 10); cellnum++) {
			webElementUtil.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelutil.readStringData("trellotestcasedata", 10, cellnum));
			webElementUtil.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelutil.readNumericData("trellotestcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		deleteBoard();
		logout();
	}

	@Test (priority = 6)
	public void swapTheList() throws Throwable {
		// =========================================================================
		// To create the board and List in board
		// =========================================================================
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelutil.readStringData("trellotestcasedata", 2, 1));
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdpage = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdpage.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create the board
		// ===================================================
		TrelloCreatedBoardPage createdboard2 = new TrelloCreatedBoardPage(driver);
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 10); cellnum++) {
			webElementUtil.sendkeysOnVisibleTextField(driver, createdboard2.enterListTitleTextField(),
					excelutil.readStringData("trellotestcasedata", 10, cellnum));
			webElementUtil.submitOnVisibleElement(driver, createdboard2.submitAddListButton());
		}
		Assert.assertEquals(createdboard2.listsCreated().size(), excelutil.readNumericData("trellotestcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =========================================================================
		// Instructions To swipe the lists
		// =========================================================================
		Reporter.log("Order of Lists before swapping", true);
		for (WebElement listName : createdboard2.createdListNames()) {
			String text = listName.getText();
			Reporter.log(text, true);
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(createdboard2.listInBoard(excelutil.readStringData("trellotestcasedata", 10, 1)))
				.pause(1000).clickAndHold().pause(1000).moveByOffset(300, 20).pause(1000).release().build().perform();
		Reporter.log("Order of Lists after swapping", true);
		for (WebElement listName : createdboard2.createdListNames()) {
			String text = listName.getText();
			Reporter.log(text, true);
		}
		deleteBoard();
		logout();
	}

	@Test (priority = 7)
	public void sortCardsAlpabetically() throws Throwable {
		// =================================================================================================
		// Create the 2 list in the board
		// =================================================================================================
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelutil.readStringData("trellotestcasedata", 2, 1));
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create 2 list in the board
		// ===================================================
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 10); cellnum++) {
			webElementUtil.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelutil.readStringData("trellotestcasedata", 10, cellnum));
			webElementUtil.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelutil.readNumericData("trellotestcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =================================================================================================
		// Sorting the cards in list alphabetically
		// =================================================================================================
		webElementUtil.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelutil.readStringData("trellotestcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelutil.getLastCellNumInSheet("trellotestcasedata", 12); cellNum++) {
			String data = excelutil.readStringData("trellotestcasedata", 12, cellNum);
			webElementUtil.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelutil.readStringData("trellotestcasedata", 10, 1)), data);
			webElementUtil.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelutil.readStringData("trellotestcasedata", 10, 1)));
		}
		Reporter.log("Card name before sorting", true);
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtil.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		webElementUtil.clickOnVisibleElement(driver,
				createdboard.listMenuButton(excelutil.readStringData("trellotestcasedata", 10, 1)));
		webElementUtil.clickOnVisibleElement(driver, createdboard.cardNameSortBy());
		webElementUtil.clickOnVisibleElement(driver, createdboard.cardSortByAlphabetically());
		Reporter.log("Card name After sorting", true);
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtil.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		deleteBoard();
		logout();
	}

	public void logout() throws Throwable {
		// loginToAccount();
		TrelloCreatedBoardPage createdboard4 = new TrelloCreatedBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, createdboard4.profieMenuButton());
		Assert.assertTrue(webElementUtil.displayOfElement(driver, createdboard4.menulogoutButton()),
				"Logout Option in menu is not display");
		Reporter.log("LogOut option is Displayed");
		webElementUtil.clickOnVisibleElement(driver, createdboard4.menulogoutButton());
		LogoutOfAtlassianAccountPage logoutPage = new LogoutOfAtlassianAccountPage(driver);
		String logoupageUrlContains = excelutil.readStringData("trellotestcasedata", 13, 1);
		Assert.assertTrue(webdriverUtil.explicitwaitForUrlcontains(driver, logoupageUrlContains),
				"Log out of your Atlassian account page is not displayed and verified upon url contains email reference.");
		Reporter.log(
				"Log out of your Atlassian account page is displayed and verified upon url contains email reference.");
		webElementUtil.clickOnVisibleElement(driver, logoutPage.logoutButton());
		String homepageUrlContains = excelutil.readStringData("trellotestcasedata", 14, 1);
		// it is throwing timeout Exception due to some problem
		Assert.assertTrue(webdriverUtil.explicitwaitForUrlcontains(driver, homepageUrlContains),
				"Log out of your Atlassian account is not successfull and verified upon url contains email reference.");
		Reporter.log(
				"Log out of your Atlassian account is successfull and verified upon homepage URL");
	}

	@Test (priority = 8)
	public void getCountOfCardAndList() throws Throwable {
		//sortCardsAlpabetically();
		// =================================================================================
		// Create cards and lists in the created board
		// =================================================================================
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		// Validating Title
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");

		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		// Validating Title
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		// validating URL
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
		webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
				excelutil.readStringData("trellotestcasedata", 2, 1));
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
		// Validating URL
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		// Validating BoardName
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 2, 1);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		// ===================================================
		// Instruction to create 2 list in the board
		// ===================================================
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 10); cellnum++) {
			webElementUtil.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelutil.readStringData("trellotestcasedata", 10, cellnum));
			webElementUtil.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelutil.readNumericData("trellotestcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		// =================================================================================================
		// Sorting the cards in list alphabetically
		// =================================================================================================
		webElementUtil.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelutil.readStringData("trellotestcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelutil.getLastCellNumInSheet("trellotestcasedata", 12); cellNum++) {
			String data = excelutil.readStringData("trellotestcasedata", 12, cellNum);
			webElementUtil.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelutil.readStringData("trellotestcasedata", 10, 1)), data);
			webElementUtil.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelutil.readStringData("trellotestcasedata", 10, 1)));
		}
		Reporter.log("Cards in list");
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtil.getTagtexOfElement(driver, element);
			Reporter.log(text, true);
		}
		// =================================================================================
		// Get the count of created cards and list in the board
		// =================================================================================

		int countOfList = createdboard.createdListNames().size();
		int countOfCardsInList = createdboard.sortedCardText().size();
		Reporter.log("Count of created lists in Board : " + countOfList);
		Reporter.log("Ccount of cards created in list : " + countOfCardsInList);
		deleteBoard();
		logout();
	}

	@Test (priority = 9)
	public void moveLoadedListToAnotherBoard() throws Throwable {
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webElementUtil.clickOnVisibleElement(driver, homepage.loginLinkText());
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginPage.getUsernameTextField(),
				excelutil.readStringData("trellotestcasedata", 0, 1));
		webElementUtil.submitOnVisibleElement(driver, loginPage.getContinueButton());
		String completeLoginToContinuePageTitle = excelutil.readStringData("trellotestcasedata", 6, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, completeLoginToContinuePageTitle), true,
				"Trello login to continue page is not displayed and verified upon title.");
		Reporter.log("Trello login to continue page is displayed and verified upon title.");
		TrelloLoginToContinuePage loginToContinuepage = new TrelloLoginToContinuePage(driver);
		webElementUtil.sendkeysOnVisibleTextField(driver, loginToContinuepage.passwordTextField(),
				excelutil.readStringData("trellotestcasedata", 1, 1));
		webElementUtil.submitOnVisibleElement(driver, loginToContinuepage.loginButton());
		String expectedboardTitle = excelutil.readStringData("trellotestcasedata", 7, 1);
		Assert.assertEquals(webdriverUtil.explicitWaitForTitles(driver, expectedboardTitle), true,
				"Trello board page is not displayed and verified upon title.");
		Reporter.log("Trello board page is displayed and verified upon title.");
		String boardpageUrlContains = excelutil.readStringData("trellotestcasedata", 8, 1);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, boardpageUrlContains), true,
				"Trello board page is not displayed and verified upon url contains email reference.");
		Reporter.log("Trello board page is displayed and verified upon url contains email reference.");
		TrelloAccountBoardPage acountBoardpage = new TrelloAccountBoardPage(driver);
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 15); cellnum++) {
			webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createDropdownButton());
			webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createBoardOption());
			webElementUtil.sendkeysOnVisibleTextField(driver, acountBoardpage.boardTitleTextfield(),
					excelutil.readStringData("trellotestcasedata", 15, cellnum));
			webElementUtil.clickOnVisibleElement(driver, acountBoardpage.createButton());
			if (cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 15) - 1) {
				driver.navigate().back();
			}
		}
		String actualCreatedBoardpageUrlContains = excelutil.readStringData("trellotestcasedata", 15, 2);
		Assert.assertEquals(webdriverUtil.explicitwaitForUrlcontains(driver, actualCreatedBoardpageUrlContains), true,
				"Created board page is not displayed and verified upon url contains boardname.");
		Reporter.log("Created board page is displayed and verified upon url contains boardname.");
		TrelloCreatedBoardPage createdboard = new TrelloCreatedBoardPage(driver);
		String actualCreatedBoardName = webElementUtil.getTagtexOfElement(driver, createdboard.boardNameText());
		String expectedCreatedBoardName = excelutil.readStringData("trellotestcasedata", 15, 2);
		Assert.assertTrue(actualCreatedBoardName.equals(expectedCreatedBoardName),
				"Created board page is not displayed and verified upon boardname.");
		Reporter.log("Created board page is displayed and verified upon boardname.");
		//======================================================================================
		for (int cellnum = 1; cellnum < excelutil.getLastCellNumInSheet("trellotestcasedata", 10); cellnum++) {
			webElementUtil.sendkeysOnVisibleTextField(driver, createdboard.enterListTitleTextField(),
					excelutil.readStringData("trellotestcasedata", 10, cellnum));
			webElementUtil.submitOnVisibleElement(driver, createdboard.submitAddListButton());
		}
		Assert.assertEquals(createdboard.listsCreated().size(), excelutil.readNumericData("trellotestcasedata", 9, 1),
				"2 lists not created and varified upon count");
		Reporter.log("2 lists successfully created and varified upon count");
		//===================================================================
		webElementUtil.clickOnVisibleElement(driver,
				createdboard.toAddACard(excelutil.readStringData("trellotestcasedata", 10, 1)));
		for (int cellNum = 1; cellNum < excelutil.getLastCellNumInSheet("trellotestcasedata", 12); cellNum++) {
			String data = excelutil.readStringData("trellotestcasedata", 12, cellNum);
			webElementUtil.sendkeysOnVisibleTextField(driver,
					createdboard.enterTextInListCard(excelutil.readStringData("trellotestcasedata", 10, 1)), data);
			webElementUtil.clickOnVisibleElement(driver,
					createdboard.addCardButtonInList(excelutil.readStringData("trellotestcasedata", 10, 1)));
		}
		Reporter.log("Cards name created");
		for (WebElement element : createdboard.sortedCardText()) {
			String text = webElementUtil.getTagtexOfElement(driver, element);
			Reporter.log(text);
		}
		//==========================
		//To move the list from one board to another board
		//==========================
		webElementUtil.clickOnVisibleElement(driver, createdboard.listMenuButton(excelutil.readStringData("trellotestcasedata", 10, 1)));//vinay
		webElementUtil.clickOnVisibleElement(driver, createdboard.moveToOptionInListMenu());
		Select boardDropdown = new Select(createdboard.boardDropdownInMoveToPopup());
		boardDropdown.selectByVisibleText(excelutil.readStringData("trellotestcasedata", 15, 1));//createdboard1
		webElementUtil.submitOnVisibleElement(driver, createdboard.submitMoveButton());
		deleteBoard();
		webElementUtil.clickOnVisibleElement(driver, acountBoardpage.selectBoardOnAccountPage(excelutil.readStringData("trellotestcasedata", 15, 1)));//sql
		Reporter.log("List moved sucessfully");
		deleteBoard();
		logout();
	}
}

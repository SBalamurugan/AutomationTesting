package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class RbcreateUser {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	public Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	@FindBy(xpath = "//*[@id='left-panel']/nav/ul[5]/li/a")
	WebElement menu_securityclick;

	@FindBy(xpath = "//*[@id='left-panel']/nav/ul[5]/li/ul/li[1]/a")
	WebElement menu_userclick;

	@FindBy(xpath ="//*[@id=\"filterSlider\"]/header/button")
	WebElement btn_createuser;

	@FindBy(id="email") 
	WebElement txt_email;

	@FindBy(id="firstName") 
	WebElement txt_firstName;

	@FindBy(id="lastName") 
	WebElement txt_lastName;

	@FindBy(id="mobile") 
	WebElement txt_mobile;

	@FindBy(id="select2-chosen-2") 
	WebElement dropdown_language;

	@FindBy(xpath="//*[@id=\"select2-results-2\"]/li")
	List<WebElement> list_language;

	@FindBy(id="enabledEdit")
	WebElement togglebtn_enabled;

	@FindBy(id="userPassword")
	WebElement txt_password;

	@FindBy(id="confirmPassword")
	WebElement txt_confirmpwd;

	@FindBy(id="pwdChange")
	WebElement togglebtn_pwdChange;

	@FindBy(id="pwdExpire")
	WebElement togglebtn_expiredPassword;

	@FindBy(xpath ="//*[@id=\"edit-form\"]/fieldset[2]/div/section[1]/div/button[1]")
	WebElement btn_usercreate;

	@FindBy(className ="btnCancel")
	WebElement btn_usercreatecancel;
	
	@FindBy(className = "nav nav-tabs")
	WebElement tab_portals;

	@FindBy(id = "select2-chosen-4")
	WebElement dropdown_corprole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_corprole;

	@FindBy(id = "select2-chosen-16")
	WebElement dropdown_growerrole;

	@FindBy(xpath = "//ul[@id='select2-results-16']/li")
	List<WebElement> list_growerrole;
	
	@FindBy(id = "select2-chosen-27")
	WebElement dropdown_warehouserole;

	@FindBy(xpath = "//ul[@id='select2-results-4']/li")
	List<WebElement> list_warehouserole;

	@FindBy(id = "select2-chosen-10")
	WebElement dropdown_partnerrole;

	@FindBy(xpath = "//ul[@id='select2-results-10']/li")
	List<WebElement> list_partnerrole;
	
	@FindBy(id="errorContent")
	WebElement txt_alertmsg;
	
	public RbcreateUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Method used for selecting the role based on portal
	 * 
	 * @param	portal, role
	 */
	public void selectPortalRole(String portal, String role) {
		try {
			if(portal.equalsIgnoreCase("Corporate Portal")){
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_corprole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_corprole, role);
			} else if (portal.equalsIgnoreCase("Corporate Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_growerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_growerrole, role);
			}else if (portal.equalsIgnoreCase("Warehouse Portal")) {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_warehouserole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_warehouserole, role);
			}else {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_partnerrole,
						"Click role dropdown : " + portal);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_partnerrole, role);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Method used for selecting the role based on portal
	 * 
	 * @param	portal, role
	 */
	public void selectLanguage(String language) {
		try {
				Thread.sleep(1000);
				inAction.buttonClick(driver, dropdown_language,
						"Click language dropdown : " + language);
				Thread.sleep(1000);
				inAction.selectByTextInDropdown(driver, list_language, language);
				Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public void enterUserInfo(String sEmail, String sFirstname,
			String sLastname, String sMobile, String sLanguage, String sPassword,
			String sConfirmpassword, String sPortal, String sRole) {
		try {

			inAction.inputText(driver, txt_email, sEmail,
					"Enter sEmail : " + sEmail);
			inAction.inputText(driver, txt_firstName, sFirstname,
					"Enter sFirstname : " + sFirstname);
			inAction.inputText(driver, txt_lastName, sLastname,
					"Enter sLastname : " + sLastname);
			inAction.inputText(driver, txt_mobile, sMobile,
					"Enter sMobile : " + sMobile);
			Thread.sleep(1000);
			selectLanguage(sLanguage);
			Thread.sleep(1000);
			inAction.inputText(driver, txt_password, sPassword,
					"Enter sPassword : " + sPassword);
			inAction.inputText(driver, txt_confirmpwd, sConfirmpassword,
					"Enter sConfirmpassword : " + sConfirmpassword);
			selectPortalRole(sPortal, sRole);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void clickCreateButton1() {
		try {
			inAction.buttonClick(driver, btn_createuser, "Click button : btn_usercreate");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void clickCreateButton() {
		try {
			inAction.buttonClick(driver, btn_usercreate, "Click button : btn_usercreate");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void userMenuClick() {

		try {

			Thread.sleep(1000);
			inAction.buttonClick(driver, menu_securityclick,
					"Click button : menu_securityclick");
			inAction.buttonClick(driver, menu_userclick,
					"Click button : menu_userclick");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public boolean alertMessageValidation() throws InterruptedException {
		System.out.println("Msg:" + txt_alertmsg.getText());

		Thread.sleep(1000);
		String alertMessage = txt_alertmsg.getText();
		Thread.sleep(1000);
		if (alertMessage.equalsIgnoreCase(constants.User_Success_Type)) {
			Assert.assertEquals(alertMessage, constants.User_Success_Type);
			return true;
		} else {
			Assert.assertNotEquals(alertMessage, constants.User_Success_Type);
			return false;
		}
	}
	
	public String alertMessage() {
		String alertMessage = txt_alertmsg.getText();
		return alertMessage;
	}
	
	@DataProvider
	public static Object[][] getData() {
		return GeneralActions.getData("User");
	}
}

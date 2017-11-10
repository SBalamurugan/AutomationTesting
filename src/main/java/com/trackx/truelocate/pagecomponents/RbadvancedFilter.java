package com.trackx.truelocate.pagecomponents;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;

public class RbadvancedFilter {
	WebDriver driver;
	String Title, Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	public Logger log4jlogger = Logger.getLogger("devpinoyLogger");

	/*
	 * Global Search elements
	 */
	@FindBy(className ="btn btn-primary  btnIcon btnGo")
	WebElement btn_go;

	@FindBy(className ="btn btn-default dropdown-Btn btnIcon btn-grey btnDownArrow")
	WebElement btn_downArrow;


	@FindBy(xpath = "//*[@id=\"filter-form\"]/fieldset/div/section[1]/label[2]/input")
	WebElement txt_searchbox;

	/*
	 * 	Advanced Search elements
	 */
	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[1]/label[2]/input")
	WebElement txt_firstnameadv;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[2]/label[2]/input")
	WebElement txt_lastnameadv;

	@FindBy(xpath = "//*[@id=\"advFilter\"]/fieldset[1]/div/section[3]/label[2]/input")
	WebElement txt_emailadv;

	@FindBy(id="select2-chosen-3") 
	WebElement dropdown_languageadv;

	@FindBy(xpath ="//*[@id=\"advFilter\"]/fieldset[1]/div/section[5]/div/label[1]/input")
	WebElement togglebtn_both;

	@FindBy(xpath ="//*[@id=\"advFilter\"]/fieldset[1]/div/section[5]/div/label[2]/input")
	WebElement togglebtn_yes;

	@FindBy(xpath ="//*[@id=\"advFilter\"]/fieldset[1]/div/section[5]/div/label[3]/input")
	WebElement togglebtn_no;

	@FindBy(className ="btn btn-primary  btnIcon btnSearch")
	WebElement btn_searchadv;

	@FindBy(className ="btn btn-default btnIcon btnClear")
	WebElement btn_clearadv;

	@FindBy(className ="btn btn-default btnIcon btnCancel")
	WebElement btn_canceladv;

	@FindBy(className ="btn btn-default dropdown-Btn btnIcon btn-grey btnDownArrow advanceBtn")
	WebElement btn_upArrow;
	
	public RbadvancedFilter(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@DataProvider
	public static Object[][] getData() {
		return GeneralActions.getData("Login");
	}
}

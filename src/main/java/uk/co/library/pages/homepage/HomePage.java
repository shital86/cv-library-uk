package uk.co.library.pages.homepage;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Accept')]")
    WebElement acceptCookies;
    @FindBy(xpath = "//input[@id='keywords']")
    WebElement jobTitle;
    @FindBy(xpath = "//input[@id='location']")
    WebElement locations;
    @FindBy(xpath = "//select[@id='distance']")
    WebElement distanceDropDown;
    @FindBy(xpath = "//button[@id='toggle-hp-search']")
    WebElement moreSearchOptionsLink;
    @FindBy(xpath = "//input[@id='salarymin']")
    WebElement salaryMin;
    @FindBy(xpath = "//input[@id='salarymax']")
    WebElement salaryMax;
    @FindBy(xpath = "//select[@id='salarytype']")
    WebElement salaryTypeDropDown;
    @FindBy(xpath = "//select[@id='tempperm']")
    WebElement jobTypeDropDown;
    @FindBy(xpath = "//input[@id='hp-search-btn']")
    WebElement findJobsBtn;

    public void clickOnAcceptCookie() {
        CustomListeners.test.log(Status.PASS,"Clicking on Accept Cookies : " + acceptCookies.toString());
        switchToiFrame("gdpr-consent-notice");
        clickOnElement(acceptCookies);
    }

    public void enterJobTitle(String jobtitles) {
        CustomListeners.test.log(Status.PASS, "Select jobtitle: " + jobtitles);
        sendTextToElement(jobTitle, jobtitles);
    }

    public void enterLocation(String location) {
        CustomListeners.test.log(Status.PASS, "Select location: " + location);
        sendTextToElement(locations, location);
    }

    public void selectDistance(String distance) {
        CustomListeners.test.log(Status.PASS, "Select Distance: " + distance);
        selectByValueFromDropDown(distanceDropDown, distance);
    }

    public void clickOnMoreSearchOptionLink() {
        CustomListeners.test.log(Status.PASS, "Click On More Option: " + moreSearchOptionsLink);
        clickOnElement(moreSearchOptionsLink);
    }

    public void enterMinSalary(String minSalary) {
        CustomListeners.test.log(Status.PASS, "Enter Minimum Salary: " + minSalary);
        sendTextToElement(salaryMin, minSalary);

    }

    public void enterMaxSalary(String maxSalary) {
        CustomListeners.test.log(Status.PASS, "Enter Maximum Salary: " + maxSalary);
        sendTextToElement(salaryMin, maxSalary);
    }

    public void selectSalaryType(String sType) {
        CustomListeners.test.log(Status.PASS, "Select Salary Type: " + sType);
        selectByValueFromDropDown(salaryTypeDropDown, sType);
    }

    public void selectJobType(String jobType) {
        CustomListeners.test.log(Status.PASS, "Select Job Type: " + jobType);
        selectByValueFromDropDown(jobTypeDropDown, jobType);
    }

    public void clickFindJobButton() {
        CustomListeners.test.log(Status.PASS, "Click On Find Jobs Button: " + findJobsBtn);
        clickOnElement(findJobsBtn);
    }


}
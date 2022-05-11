package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;
import uk.co.library.pages.homepage.HomePage;
import uk.co.library.pages.resultpage.ResultPage;
import uk.co.library.testbase.TestBase;

public class JobSearchTest extends TestBase{
    HomePage homePage;
    ResultPage resultPage;


    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"}, dataProvider = "searchCriteria", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result) throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickOnAcceptCookie();
        Thread.sleep(2000);
        homePage.enterJobTitle(jobTitle);
        Thread.sleep(2000);
        homePage.enterLocation(location);
        Thread.sleep(2000);
        homePage.selectDistance(distance);
        Thread.sleep(2000);
        homePage.clickOnMoreSearchOptionLink();
        Thread.sleep(2000);
        homePage.enterMinSalary(salaryMin);
        Thread.sleep(2000);
        homePage.enterMaxSalary(salaryMax);
        Thread.sleep(2000);
        homePage.selectSalaryType(salaryType);
        Thread.sleep(2000);
        homePage.selectJobType(jobType);
        Thread.sleep(2000);
        homePage.clickFindJobButton();
        Thread.sleep(2000);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(resultPage.verifyTheResults(jobTitle) == true, "failed to search");
        softAssert.assertAll();

    }
}

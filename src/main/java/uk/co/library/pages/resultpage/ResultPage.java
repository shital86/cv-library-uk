package uk.co.library.pages.resultpage;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class ResultPage extends Utility {
    public ResultPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[@class='search-header__title']")
    WebElement resultText;
    public Boolean verifyTheResults(String expected){
        CustomListeners.test.log(Status.PASS, "Select Job Type: " + resultText);
        Boolean result = false;
        String s = getTextFromElement(resultText);
        if (s.contains(expected)) {
            result = true;
        }
        return result;
    }
    }


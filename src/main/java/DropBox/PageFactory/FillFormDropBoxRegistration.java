package DropBox.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by svetlana on 15.04.15.
 */
public class FillFormDropBoxRegistration {

    WebDriver driver;
    @FindBy(css = "input[name='fname']")
    private WebElement firstNameInput;

    @FindBy(css = "input[name=lname]")
    private WebElement lastNameInput;

    @FindBy(css = "input[name=email]")
    private WebElement emailInput;

    @FindBy(css = "input[name=password]")
    private WebElement passwordInput;

    @FindBy(css = "input[name=email]")
    private WebElement submitButton;

    @FindBy(css = "input[name=tos_agree]")
    private WebElement checkBoxAgreement;

//    @FindBy(css = "input[id=text]")
//    private WebElement captcha;

    public FillFormDropBoxRegistration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void fillFormRegistration(String firstName, String lastName, String email, String password) {

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        checkBoxAgreement.click();
        submitButton.submit();

    }
}

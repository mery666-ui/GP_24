package com.project_name.pages;


import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }






    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passWord;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(id = "lost-password")
    public WebElement linkForgotPassword;

    @FindBy(xpath = "//*[@id='reset-password-submit']")
    public WebElement inputResetPasswordSubmit;

    @FindBy(xpath = "/p[@class='warning wrongPasswordMsg']")
    public WebElement WrongUsernamePassword;

    @FindBy(css = "a[class='toggle-password'] img")
    public WebElement iconeEyeOption;

    @FindBy(xpath = "//p[contains(@class, 'warning')]")
    public WebElement pWrongUsernamePassword;

    @FindBy(xpath = "//p[@class='warning throttledMsg']")
    public WebElement ThrottledMsg;




    public void loginPage(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginButton.click();
        // verification that we logged
    }

    public void login() {
        LoginPage loginPage=new LoginPage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passWord.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();

    }


}

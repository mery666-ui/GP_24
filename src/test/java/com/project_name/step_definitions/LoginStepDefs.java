package com.project_name.step_definitions;

import com.project_name.pages.LoginPage;
import com.project_name.utilities.ConfigurationReader;
import com.project_name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class LoginStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Login to app in Before method");
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //based on input enter that user information
        String username =null;
        String password =null;

        if(userType.equalsIgnoreCase("driver")){
            username = ConfigurationReader.getProperty("driver_username");
            password = ConfigurationReader.getProperty("driver_password");
        }else if(userType.equalsIgnoreCase("sales manager")){
            username = ConfigurationReader.getProperty("sales_manager_username");
            password = ConfigurationReader.getProperty("sales_manager_password");
        }else if(userType.equalsIgnoreCase("store manager")){
            username = ConfigurationReader.getProperty("store_manager_username");
            password = ConfigurationReader.getProperty("store_manager_password");
        }
        //send username and password and login

    }

    @Given("the user logged in with username as {string} and password as {string}")
    public void the_user_logged_in_with_username_as_and_password_as(String username, String password) {
      LoginPage loginPage=new LoginPage();
     // loginPage.login(username,password);
    }

    LoginPage loginPage = new LoginPage();

    @Given("Users Log to the application Trycloud")
    public void Users_Log_to_the_application_Trycloud() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Then("user logged in with a valid credentials")
    public void user_logged_in_with_a_valid_credentials(Map<String, String> credentials) {
        loginPage.userName.sendKeys(credentials.get("username"));
        loginPage.passWord.sendKeys(credentials.get("password"));


    }

    @Then("user click on the login button")
    public void user_click_on_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("the user is redirected to the dashboard page")
    public void the_user_is_redirected_to_the_dashboard_page() {

        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains("dashboard"));


    }



}

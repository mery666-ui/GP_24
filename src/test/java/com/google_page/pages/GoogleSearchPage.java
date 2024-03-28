//** created by Maryam 


package com.google_page.pages;

import com.google_page.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    //#1- Create the constructor and initialize the driver with object


    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement search;

}

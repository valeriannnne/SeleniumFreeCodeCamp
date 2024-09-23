package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class LinksPage extends ElementsPage{

    private By badRequestLink = By.id("bad-request");
    private By responseLink = By.id("linkResponse");

    public void clickBadRequestLink(){
        scrollToElementJS(badRequestLink);
        click(badRequestLink);
    }

    public String getResponse() throws InterruptedException {
        try {
            delay(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return find(responseLink).getText();
    }

}

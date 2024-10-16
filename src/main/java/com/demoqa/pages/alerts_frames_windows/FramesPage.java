package com.demoqa.pages.alerts_frames_windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.SwitchToUtility.*;

public class FramesPage extends Alerts_Frames_WindowsPage {

    // Locators
    private By textInFrame = By.xpath("/html/body/h1");
    private By headerFramesText = By.xpath("//div[@id='app']//h1[text()='Frames']");
    private String iFrameBigBox = "frame1";
    private By iFrameSmallBox = By.xpath("//*[@id='frame2']");

    public String getHeaderFramesText() {
        return find(headerFramesText).getText();
    }
    private void switchToBigBox() {
        switchToFrameString(iFrameBigBox);
    }

    private void switchToSmallBox() {
        //switchToFrameIndex(3);
        switchToFrameElement(find(iFrameSmallBox));
    }

    public String getTextInBigFrame() {
        switchToBigBox();  // Switch to the iframe
        String bigFrameText = find(textInFrame).getText();  // Get the text inside the iframe
        System.out.println("Big Frame Text: " + bigFrameText);
        switchToDefaultContent();
        return bigFrameText;
    }

    public String getTextInSmallFrame(){
        switchToSmallBox();
        String smallFrameText = find(textInFrame).getText();
        System.out.println("Small Frame Text: " + smallFrameText);
        switchToDefaultContent();
        return smallFrameText;
    }
}

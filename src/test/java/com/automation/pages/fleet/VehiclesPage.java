package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")//space oldugu icin partialText kullandik
    private WebElement createCar;


    public void clickToCreateCar(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }
    //neden burda method yazdik, cunku bu applicationda wait problemli bir sey.
    // o yuzden sorunla karsilasmamak icin method icine yazip wait koyuyoruz ve clickable
    //olmasini sagliyoruz. Test, sadece hazir olan seyi alip kullanmali, oysa Page in gorevi
    //Test in sorunsuz isini yapmasini saglamak. ne gerekliyse onu saglamak.
}

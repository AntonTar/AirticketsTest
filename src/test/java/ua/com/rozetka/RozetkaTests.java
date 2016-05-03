package ua.com.rozetka;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.junit.Assert.assertFalse;

public class RozetkaTests {

    @Before
    public void clearCache() {
        clearBrowserCache();
    }

    @Test
    public void closeAlertTestByButton(){
        open("http://rozetka.com.ua/");
        $(".notificationPanelBlock").click();
        $("#SubscribePushNotificationPanel").should(disappear);
    }

    @Test
    public void closeAlertTestByPic(){
        open("http://rozetka.com.ua/");
        $(".notificationPanelCross").click();
        assertFalse($("#SubscribePushNotificationPanel").isDisplayed());
    }

}

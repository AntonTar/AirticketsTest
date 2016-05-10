package ua.com.rozetka;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AirticketsTest {

    @Test
    public void ByingTicketTest() {
        open("http://www.airtickets.ru/");
        $("#from").shouldBe(visible).setValue("Кие");
        $(By.xpath(".//*[@id='autocomplete']//div[text() = 'KBP - Киев - Борисполь а/п']")).shouldBe(visible).click();
        $("#to").shouldBe(visible).setValue("Бар");
        $(By.xpath(".//*[@id='autocomplete']//div[text()='BCN - Барселона - Барселона а/п']")).shouldBe(visible).click();
        $("#departureDate").click();
        $(By.xpath(".//*[@class='ui-datepicker-group ui-datepicker-group-last']//*[@class='ui-state-default hasMouseoverEvent'][text()='1']")).click();
        $(".calendarTick show").is(visible);
        $("#returnDate").click();
        $(By.xpath(".//*[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-state-default hasMouseoverEvent'][text()='5']")).click();
        $(".calendarTick return show").is(visible);
        /*Actions builder = new Actions(getWebDriver());
        builder.moveToElement($(".radioButtonContainer.marginLeft")).click($(By.xpath(".//div[@class='radiobuttonText']")));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();*/
        $(".radioButtonContainer.marginLeft").hover();
        $((By.xpath(".//div[@class='radiobuttonText']"))).shouldBe(visible).click();
        //$(".plusMinus3DaysRadioButton .radioButtonContainer", 1).click();
        //$(".plusMinus3DaysRadioButton").find(byText("+/- 3 дня")).click();
        //$(".radioButtonContainer.marginLeft").hover().click();
        //$(By.xpath(".//div[@class='radiobuttonText']")).click();
        //$(By.xpath(".//*[@name='plusMinus3']")).shouldBe(visible);
        //$(By.xpath(".//div[@class='radiobuttonText']")).click();
        //$(By.xpath(".//*[@name='plusMinus3']")).click();
        $(".radiobuttonText blackColored").is(visible);
        $("#returnDays").shouldHave(text("4"));
        $("#searchButton").click();
    }

}

package ua.com.rozetka;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AirticketsTest {

    @Test
    public void ByingTicketTest() {
        open("http://www.airtickets.ru/");
        $("#from").setValue("Кие");
        $(By.xpath(".//*[@id='autocomplete']//div[text() = 'KBP - Киев - Борисполь а/п']")).click();
        $("#to").setValue("Бар");
        $(By.xpath(".//*[@id='autocomplete']//div[text()='BCN - Барселона - Барселона а/п']")).click();
        $("#departureDate").click();
        $(By.xpath(".//*[@class='ui-datepicker-group ui-datepicker-group-last']//*[@class='ui-state-default hasMouseoverEvent'][text()='1']")).click();
        $(".calendarTick show").is(visible);
        $("#returnDate").click();
        $(By.xpath(".//*[@class='ui-datepicker-group ui-datepicker-group-first']//*[@class='ui-state-default hasMouseoverEvent'][text()='5']")).click();
        $(".calendarTick return show").is(visible);
        $(".plusMinus3DaysRadioButton").click();
        $(".radiobuttonText blackColored").is(visible);
        $("#returnDays").shouldHave(text("4"));
        $("#searchButton").click();

    }

}

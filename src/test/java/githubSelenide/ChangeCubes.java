package githubSelenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ChangeCubes {

    @BeforeAll
    static void openMaximized() {
        Configuration.startMaximized = true;
    }

    @Test
    void changeCubes() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").dragAndDropTo($("#column-b"));
        $$("#columns").first().$("header").shouldBe(text("B"));
        //sleep(3000);
    }
}

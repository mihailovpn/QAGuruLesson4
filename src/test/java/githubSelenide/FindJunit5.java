package githubSelenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FindJunit5 {

    @BeforeAll
    static void openMaximized() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void findSoftAssertions() {
        //Открываем страницу Selenide
        open("/selenide/selenide");
        //Переходим в раздел wiki
        $("#wiki-tab").click();
        //Вводим в поле поиска по Pages - SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //Убеждаемся, что в списке страниц (Pages) есть страница SoftAssertions
        $("[data-filterable-for=wiki-pages-filter]").should(text("SoftAssertions"));
    }

    @Test
    void findJUnit5onSoftAssertions() {
        //Открыть страницу SoftAssertions
        open("/selenide/selenide/wiki/SoftAssertions");
        //Проверить наличие примера кода JUnit5. Уточнить ОР.
        $(byText("Using JUnit5 extend test class:")).closest("ol")
                .sibling(0).shouldBe(cssClass("highlight-source-java"));
    }
}

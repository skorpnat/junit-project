package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainOfzPage {
    public SelenideElement pageTitle = $x("//h1[@class='qn-menu__title qn-menu__title--wrap']");
    public SelenideElement ofzLink = $x("//a[contains(@href, 'SU26243RMFS4')]");

}

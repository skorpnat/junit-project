package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class OfzPage {
    public SelenideElement buyShares = $(".buy-shares__btn");

    public SelenideElement discussShares = $(".qn-menu__btn qn-menu__btn--simple");

    public SelenideElement pageTitle = $x("//h1[@class='qn-menu__title qn-menu__title--wrap']");
    public SelenideElement calendarTable = $x("//table[@class='custom-table custom-card']");
    public SelenideElement priceScheme = $("#bond_results_container");

}

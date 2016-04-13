package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.CountryFactoryWeb;
import cc.univ.page.CountryListPage;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.util.List;

public class CountryListPageWeb implements CountryListPage {
    private static final String TAG_NAME_COUNTRY_LIST = Constants.TAG_NAME_SELECT;
    private static final String TAG_NAME_COUNTRY = Constants.TAG_NAME_OPTION;
    private static final String ATTRIBUTE_CODE = Constants.ATTRIBUTE_VALUE;
    private static final String TAG_NAME_SEARCH_BUTTON = Constants.TAG_NAME_INPUT;
    private static final String CLASS_NAME_SEARCH_BUTTON = "submit";

    @NotNull
    private final CountryFactoryWeb countryFactoryWeb;

    public CountryListPageWeb(
            @NotNull CountryFactoryWeb countryFactoryWeb) {
        this.countryFactoryWeb = countryFactoryWeb;
    }

    public void selectCountry(
            @NotNull WebDriver driver, @NotNull Country country) {
        WebElement countryListElement = driver.findElement(By.tagName(TAG_NAME_COUNTRY_LIST));
        WebElement countryElement = countryListElement.findElement(new ByAll(
                new By.ByCssSelector("[" + ATTRIBUTE_CODE + "=\"" + country.getCode() + "\"]"),
                By.tagName(TAG_NAME_COUNTRY)));
        countryElement.click();
    }

    public void clickSearchButton(@NotNull WebDriver driver) {
        driver.findElement(new ByAll(
                By.className(CLASS_NAME_SEARCH_BUTTON),
                By.tagName(TAG_NAME_SEARCH_BUTTON)))
                .click();
    }

    @NotNull
    public List<Country> collectCountries(@NotNull WebDriver driver) {
        return countryFactoryWeb.findList(driver);
    }
}

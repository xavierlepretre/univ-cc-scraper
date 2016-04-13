package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface CountryListPage {
    void selectCountry(@NotNull WebDriver driver, @NotNull Country country);

    void clickSearchButton(@NotNull WebDriver driver);

    @NotNull
    List<Country> collectCountries(@NotNull WebDriver driver);
}

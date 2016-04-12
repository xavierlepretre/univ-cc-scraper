package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface CountryListPage {
    void selectCountry(@NotNull Country country);

    void clickSearchButton();

    @NotNull
    List<Country> collectCountries();
}

package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;

public interface CountryPage {
    void selectCountry(@NotNull Country country);

    void clickSearchButton();
}

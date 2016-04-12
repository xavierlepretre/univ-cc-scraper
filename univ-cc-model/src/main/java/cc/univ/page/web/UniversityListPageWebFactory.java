package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface UniversityListPageWebFactory {
    @NotNull
    UniversityListPageWeb create(
            @NotNull WebDriver webDriver,
            @NotNull Country country,
            @NotNull UniversityFactoryWeb universityFactoryWeb);
}

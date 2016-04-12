package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UniversityListPageWebFactoryImpl implements UniversityListPageWebFactory {
    private static final String TAG_NAME_ROOT = Constants.TAG_NAME_HTML;

    @NotNull
    @Override
    public UniversityListPageWeb create(
            @NotNull WebDriver webDriver,
            @NotNull Country country,
            @NotNull UniversityFactoryWeb universityFactoryWeb) {
        return new UniversityListPageWeb(
                webDriver.findElement(By.tagName(TAG_NAME_ROOT)),
                country,
                universityFactoryWeb);
    }
}

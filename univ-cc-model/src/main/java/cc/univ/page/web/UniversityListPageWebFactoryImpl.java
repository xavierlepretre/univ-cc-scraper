package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPageFactory;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class UniversityListPageWebFactoryImpl implements UniversityListPageFactory {
    private static final String TAG_NAME_ROOT = Constants.TAG_NAME_HTML;

    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;

    public UniversityListPageWebFactoryImpl(@NotNull UniversityFactoryWeb universityFactoryWeb) {
        this.universityFactoryWeb = universityFactoryWeb;
    }

    @NotNull
    @Override
    public UniversityListPageWeb create(
            @NotNull WebDriver webDriver,
            @NotNull Country country) {
        return new UniversityListPageWeb(
                universityFactoryWeb);
    }
}

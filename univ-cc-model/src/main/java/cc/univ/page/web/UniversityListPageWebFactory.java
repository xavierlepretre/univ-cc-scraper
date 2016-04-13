package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPageFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class UniversityListPageWebFactory implements UniversityListPageFactory {
    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;

    public UniversityListPageWebFactory(@NotNull UniversityFactoryWeb universityFactoryWeb) {
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

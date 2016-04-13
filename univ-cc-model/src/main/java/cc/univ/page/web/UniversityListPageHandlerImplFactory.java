package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPageHandler;
import cc.univ.page.UniversityListPageHandlerFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class UniversityListPageHandlerImplFactory implements UniversityListPageHandlerFactory {
    @NotNull
    private final UniversityFactoryWeb universityFactoryWeb;
    @NotNull
    private final UniversityListPageWebFactory universityListPageWebFactory;

    public UniversityListPageHandlerImplFactory(
            @NotNull UniversityFactoryWeb universityFactoryWeb,
            @NotNull UniversityListPageWebFactory universityListPageWebFactory) {
        this.universityFactoryWeb = universityFactoryWeb;
        this.universityListPageWebFactory = universityListPageWebFactory;
    }

    @NotNull
    @Override
    public UniversityListPageHandler create(@NotNull WebDriver driver, @NotNull Country country) {
        return new UniversityListPageHandlerImpl(
                driver,
                country,
                universityFactoryWeb,
                universityListPageWebFactory);
    }
}

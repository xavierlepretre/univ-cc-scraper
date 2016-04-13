package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.page.UniversityListPageFactory;
import cc.univ.page.UniversityListPageHandler;
import cc.univ.page.UniversityListPageHandlerFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public class UniversityListPageHandlerImplFactory implements UniversityListPageHandlerFactory {
    @NotNull
    private final UniversityListPageFactory universityListPageFactory;

    public UniversityListPageHandlerImplFactory(
            @NotNull UniversityListPageFactory universityListPageFactory) {
        this.universityListPageFactory = universityListPageFactory;
    }

    @NotNull
    @Override
    public UniversityListPageHandler create(@NotNull WebDriver driver, @NotNull Country country) {
        return new UniversityListPageHandlerImpl(
                universityListPageFactory);
    }
}

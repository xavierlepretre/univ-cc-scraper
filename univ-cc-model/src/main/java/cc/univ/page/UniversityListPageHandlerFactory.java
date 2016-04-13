package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface UniversityListPageHandlerFactory {
    @NotNull
    UniversityListPageHandler create(
            @NotNull WebDriver driver,
            @NotNull Country country);
}

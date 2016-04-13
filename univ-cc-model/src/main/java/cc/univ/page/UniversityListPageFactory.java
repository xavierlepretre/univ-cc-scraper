package cc.univ.page;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface UniversityListPageFactory {
    @NotNull
    UniversityListPage create(
            @NotNull WebDriver webDriver,
            @NotNull Country country);
}

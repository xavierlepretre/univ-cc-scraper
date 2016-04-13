package cc.univ.page;

import cc.univ.model.ScrapedInfo;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;

public interface UnivTraverser {
    @NotNull
    ScrapedInfo scrape(@NotNull WebDriver driver);
}

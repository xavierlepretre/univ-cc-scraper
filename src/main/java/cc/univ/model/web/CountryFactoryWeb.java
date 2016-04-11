package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.auto.CountryAuto;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryFactoryWeb {
    private static final String ATTRIBUTE_CODE = Constants.ATTRIBUTE_VALUE;
    private static final String ATTRIBUTE_NAME = Constants.ATTRIBUTE_INNER_HTML;
    private static final Pattern MATCH_NAME = Pattern.compile("(.*) \\(\\d+\\)");
    private static final String TAG_NAME_SELECT = Constants.TAG_NAME_SELECT;
    private static final String TAG_NAME_OPTION = Constants.TAG_NAME_OPTION;

    @NotNull
    public Country create(@NotNull WebElement optionElement) {
        String nameAndCount = optionElement.getAttribute(ATTRIBUTE_NAME);
        Matcher matcher = MATCH_NAME.matcher(nameAndCount);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Could not parse correctly: " + nameAndCount);
        }
        return CountryAuto.create(
                optionElement.getAttribute(ATTRIBUTE_CODE),
                matcher.group(1));
    }

    @NotNull
    public List<Country> createList(@NotNull WebElement selectElement) {
        List<Country> created = new ArrayList<Country>();
        for (WebElement optionElement : selectElement.findElements(By.tagName(TAG_NAME_OPTION))) {
            try {
                created.add(create(optionElement));
            } catch (IllegalArgumentException ignore) {
                // we skip
            }
        }
        return created;
    }

    @NotNull
    public List<Country> findList(@NotNull WebDriver driver) {
        return createList(driver.findElement(By.tagName(TAG_NAME_SELECT)));
    }
}

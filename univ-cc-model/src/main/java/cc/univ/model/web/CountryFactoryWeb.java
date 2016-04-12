package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.auto.CountryAuto;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryFactoryWeb {
    private static final String ATTRIBUTE_CODE = Constants.ATTRIBUTE_VALUE;
    private static final String ATTRIBUTE_NAME = Constants.ATTRIBUTE_INNER_HTML;
    private static final Pattern MATCH_NAME = Pattern.compile("(.*) \\(\\d+\\)");
    private static final String TAG_NAME_COUNTRY_LIST = Constants.TAG_NAME_SELECT;
    private static final String TAG_NAME_COUNTRY = Constants.TAG_NAME_OPTION;

    @NotNull
    public Country create(@NotNull WebElement countryElement) {
        String nameAndCount = countryElement.getAttribute(ATTRIBUTE_NAME);
        Matcher matcher = MATCH_NAME.matcher(nameAndCount);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Could not parse correctly: " + nameAndCount);
        }
        return CountryAuto.create(
                countryElement.getAttribute(ATTRIBUTE_CODE),
                matcher.group(1));
    }

    @NotNull
    public List<Country> createList(@NotNull WebElement countryListElement) {
        List<Country> created = new ArrayList<Country>();
        for (WebElement countryElement : countryListElement.findElements(By.tagName(TAG_NAME_COUNTRY))) {
            try {
                created.add(create(countryElement));
            } catch (IllegalArgumentException ignore) {
                // we skip
            }
        }
        return created;
    }

    @NotNull
    public List<Country> findList(@NotNull WebElement webElement) {
        return createList(webElement.findElement(By.tagName(TAG_NAME_COUNTRY_LIST)));
    }
}

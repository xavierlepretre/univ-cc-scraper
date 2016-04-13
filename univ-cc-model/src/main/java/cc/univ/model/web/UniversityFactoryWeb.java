package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.auto.UniversityAuto;
import html.Constants;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class UniversityFactoryWeb {
    private static final String ATTRIBUTE_NAME = Constants.ATTRIBUTE_INNER_HTML;
    private static final String ATTRIBUTE_URL = Constants.ATTRIBUTE_HREF;
    private static final String TAG_NAME_ANCHOR = Constants.TAG_NAME_ANCHOR;
    private static final String TAG_NAME_UNIVERSITY_LIST = Constants.TAG_NAME_ORDERED_LIST;
    private static final String TAG_NAME_UNIVERSITY = Constants.TAG_NAME_LIST_ITEM;

    @NotNull
    public University create(
            @NotNull Country country,
            @NotNull WebElement universityElement) {
        WebElement anchorElement = universityElement.findElement(By.tagName(TAG_NAME_ANCHOR));
        return UniversityAuto.create(
                country,
                anchorElement.getAttribute(ATTRIBUTE_NAME),
                anchorElement.getAttribute(ATTRIBUTE_URL));
    }

    @NotNull
    public List<University> createList(
            @NotNull Country country,
            @NotNull WebElement universityListElement) {
        List<University> created = new ArrayList<University>();
        for (WebElement universityElement : universityListElement.findElements(By.tagName(TAG_NAME_UNIVERSITY))) {
            created.add(create(country, universityElement));
        }
        return created;
    }

    @NotNull
    public List<University> findList(
            @NotNull Country country,
            @NotNull WebDriver driver) {
        return createList(
                country,
                driver.findElement(By.tagName(TAG_NAME_UNIVERSITY_LIST)));
    }
}

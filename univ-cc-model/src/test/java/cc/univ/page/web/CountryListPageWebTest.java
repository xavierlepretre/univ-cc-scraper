package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.CountryFactoryWeb;
import cc.univ.page.CountryListPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CountryListPageWebTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testClickSearch_goesToOtherPage() throws Exception {
        URL resource = getClass().getResource("page_world.html");
        driver.get("file://" + resource.getPath());
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("cn");

        CountryListPage countryListPage = new CountryListPageWeb(
                driver.findElement(By.tagName("html")),
                mock(CountryFactoryWeb.class));

        countryListPage.selectCountry(country);
        countryListPage.clickSearchButton();

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.urlContains("search"));

        assertThat(driver.getCurrentUrl()).contains("search.php");
        assertThat(driver.getCurrentUrl()).contains("dom=cn");
    }

    @Test
    public void testCollect_passesOn() throws Exception {
        WebElement element = mock(WebElement.class);
        CountryFactoryWeb factoryWeb = mock(CountryFactoryWeb.class);
        CountryListPage countryListPage = new CountryListPageWeb(
                element,
                factoryWeb);

        countryListPage.collectCountries();

        verify(factoryWeb).findList(element);
    }
}
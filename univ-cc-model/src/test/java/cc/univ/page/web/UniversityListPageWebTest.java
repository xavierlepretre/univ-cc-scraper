package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.web.UniversityFactoryWeb;
import cc.univ.page.UniversityListPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UniversityListPageWebTest {
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
    public void testChinaClick_goesToOtherPage() throws Exception {
        URL resource = getClass().getResource("page_china_1.html");
        driver.get("file://" + resource.getPath());
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("cn");

        UniversityListPage universityListPage = new UniversityListPageWeb(
                mock(UniversityFactoryWeb.class));

        assertThat(universityListPage.hasNextButton(driver)).isTrue();
        universityListPage.clickNextButton(driver);

        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.urlContains("51"));

        assertThat(driver.getCurrentUrl()).contains("search.php");
        assertThat(driver.getCurrentUrl()).contains("dom=cn");
        assertThat(driver.getCurrentUrl()).contains("start=51");
    }

    @Test
    public void testAndorra_noNext() throws Exception {
        URL resource = getClass().getResource("page_andorra_1.html");
        driver.get("file://" + resource.getPath());
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("ad");

        UniversityListPage universityListPage = new UniversityListPageWeb(
                mock(UniversityFactoryWeb.class));

        assertThat(universityListPage.hasNextButton(driver)).isFalse();
    }

    @Test
    public void testCollect_passesOn() throws Exception {
        WebElement element = mock(WebElement.class);
        Country country = mock(Country.class);
        UniversityFactoryWeb factoryWeb = mock(UniversityFactoryWeb.class);
        UniversityListPage universityListPage = new UniversityListPageWeb(
                factoryWeb);

        universityListPage.collectUniversities(driver, country);

        verify(factoryWeb).findList(country, driver);
    }
}
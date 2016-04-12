package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class UniversityFactoryWebLiveTest {
    private  WebDriver driver;
    private UniversityFactoryWeb universityFactoryWeb;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        universityFactoryWeb = new UniversityFactoryWeb();
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void testGotUniversitiesFromPageChina1() throws Exception {
        driver.get("http://univ.cc/search.php?dom=cn&key=&start=1");
        Country country = mock(Country.class);
        List<University> universities = universityFactoryWeb.findList(
                country,
                driver.findElement(By.tagName("html")));

        assertThat(universities).hasSize(50);
        assertThat(universities.get(49).getName()).isEqualTo("China Agricultural University");
        assertThat(universities.get(49).getUrl()).isEqualTo("http://www.cau.edu.cn/");
    }
}
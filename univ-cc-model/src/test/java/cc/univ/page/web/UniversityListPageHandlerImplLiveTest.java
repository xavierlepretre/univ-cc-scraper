package cc.univ.page.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.web.UniversityFactoryWeb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UniversityListPageHandlerImplLiveTest {
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
    public void testAndorra_collects1() throws Exception {
        driver.get("http://univ.cc/search.php?dom=ad&key=&start=1");
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("ad");

        UniversityListPageHandlerImpl pageHandler = new UniversityListPageHandlerImpl(
                new UniversityListPageWebFactory(new UniversityFactoryWeb()));

        List<University> universities = pageHandler.traverseAndCollect(driver, country);
        assertThat(universities).hasSize(1);
        assertThat(universities.get(0).getName()).isEqualTo("University of Andorra");
        assertThat(universities.get(0).getUrl()).isEqualTo("http://www.uda.ad/");
    }

    @Test
    public void testAlgeria_collects31() throws Exception {
        driver.get("http://univ.cc/search.php?dom=dz&key=&start=1");
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("dz");

        UniversityListPageHandlerImpl pageHandler = new UniversityListPageHandlerImpl(
                new UniversityListPageWebFactory(new UniversityFactoryWeb()));

        List<University> universities = pageHandler.traverseAndCollect(driver, country);
        assertThat(universities).hasSize(31);
        assertThat(universities.get(0).getName()).isEqualTo("Centre Universitaire de Jijel");
        assertThat(universities.get(0).getUrl()).isEqualTo("http://www.univ-jijel.dz/");
    }

    @Test
    public void testArgentina_collects88() throws Exception {
        driver.get("http://univ.cc/search.php?dom=ar&key=&start=1");
        Country country = mock(Country.class);
        when(country.getCode()).thenReturn("ar");

        UniversityListPageHandlerImpl pageHandler = new UniversityListPageHandlerImpl(
                new UniversityListPageWebFactory(new UniversityFactoryWeb()));

        List<University> universities = pageHandler.traverseAndCollect(driver, country);
        assertThat(universities).hasSize(88);
        assertThat(universities.get(0).getName()).isEqualTo("Instituto de Enseñanza Superior del Ejército");
        assertThat(universities.get(0).getUrl()).isEqualTo("http://www.iese.edu.ar/");
    }
}
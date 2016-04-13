package cc.univ.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ScrapedInfo {
    @NotNull
    List<Country> getCountries();

    @NotNull
    List<University> getUniversities();
}

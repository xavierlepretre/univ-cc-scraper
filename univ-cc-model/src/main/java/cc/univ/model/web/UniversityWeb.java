package cc.univ.model.web;

import cc.univ.model.Country;
import cc.univ.model.University;
import cc.univ.model.auto.UniversityAuto;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@AutoValue
abstract public class UniversityWeb implements University{
    @NotNull
    abstract UniversityAuto getUniversityAuto();

    @NotNull
    public Country getCountry() {
        return getUniversityAuto().getCountry();
    }

    @NotNull
    public String getName() {
        return getUniversityAuto().getName();
    }

    @NotNull
    public String getUrl() {
        return getUniversityAuto().getUrl();
    }

    @NotNull static UniversityWeb create(@NotNull UniversityAuto universityAuto) {
        return new AutoValue_UniversityWeb(universityAuto);
    }
}

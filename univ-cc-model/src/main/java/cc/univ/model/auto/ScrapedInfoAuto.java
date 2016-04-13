package cc.univ.model.auto;

import cc.univ.model.Country;
import cc.univ.model.ScrapedInfo;
import cc.univ.model.University;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

@AutoValue
abstract public class ScrapedInfoAuto implements ScrapedInfo {
    @NotNull
    public static ScrapedInfoAuto create(
            @NotNull List<Country> countries,
            @NotNull List<University> universities) {
        return new AutoValue_ScrapedInfoAuto(
                Collections.unmodifiableList(countries),
                Collections.unmodifiableList(universities));
    }
}

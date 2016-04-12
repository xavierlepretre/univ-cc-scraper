package cc.univ.model.auto;

import cc.univ.model.Country;
import cc.univ.model.University;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@AutoValue
abstract public class UniversityAuto implements University {
    public static UniversityAuto create(
            @NotNull Country country,
            @NotNull String name,
            @NotNull String url) {
        return new AutoValue_UniversityAuto(country, name, url);
    }
}

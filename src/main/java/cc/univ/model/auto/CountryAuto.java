package cc.univ.model.auto;

import cc.univ.model.Country;
import com.google.auto.value.AutoValue;
import org.jetbrains.annotations.NotNull;

@AutoValue
abstract public class CountryAuto implements Country {
    public static CountryAuto create(@NotNull String code, @NotNull String name) {
        return new AutoValue_CountryAuto(code, name);
    }
}

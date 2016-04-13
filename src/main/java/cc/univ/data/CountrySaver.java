package cc.univ.data;

import cc.univ.model.Country;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface CountrySaver {
    void add(@NotNull Country country);

    void add(@NotNull Collection<Country> countries);

    void save();
}


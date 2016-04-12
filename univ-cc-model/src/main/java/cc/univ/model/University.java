package cc.univ.model;

import org.jetbrains.annotations.NotNull;

public interface University {
    @NotNull
    Country getCountry();

    @NotNull
    String getName();

    @NotNull
    String getUrl();
}

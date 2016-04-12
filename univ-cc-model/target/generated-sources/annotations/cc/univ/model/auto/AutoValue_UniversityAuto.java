
package cc.univ.model.auto;

import cc.univ.model.Country;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UniversityAuto extends UniversityAuto {

  private final Country country;
  private final String name;
  private final String url;

  AutoValue_UniversityAuto(
      Country country,
      String name,
      String url) {
    if (country == null) {
      throw new NullPointerException("Null country");
    }
    this.country = country;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    if (url == null) {
      throw new NullPointerException("Null url");
    }
    this.url = url;
  }

  @NotNull
  @Override
  public Country getCountry() {
    return country;
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @NotNull
  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "UniversityAuto{"
        + "country=" + country + ", "
        + "name=" + name + ", "
        + "url=" + url
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UniversityAuto) {
      UniversityAuto that = (UniversityAuto) o;
      return (this.country.equals(that.getCountry()))
           && (this.name.equals(that.getName()))
           && (this.url.equals(that.getUrl()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.country.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.url.hashCode();
    return h;
  }

}

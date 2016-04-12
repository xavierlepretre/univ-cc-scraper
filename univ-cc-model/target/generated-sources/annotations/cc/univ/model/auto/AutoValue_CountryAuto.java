
package cc.univ.model.auto;

import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CountryAuto extends CountryAuto {

  private final String code;
  private final String name;

  AutoValue_CountryAuto(
      String code,
      String name) {
    if (code == null) {
      throw new NullPointerException("Null code");
    }
    this.code = code;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
  }

  @NotNull
  @Override
  public String getCode() {
    return code;
  }

  @NotNull
  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "CountryAuto{"
        + "code=" + code + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CountryAuto) {
      CountryAuto that = (CountryAuto) o;
      return (this.code.equals(that.getCode()))
           && (this.name.equals(that.getName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.code.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    return h;
  }

}

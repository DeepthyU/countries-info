/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.v3;

import com.dee.countriesinfo.domain.base.BaseCountry;

import java.util.List;

public class Country extends BaseCountry {
  private List<String> flags;

  public List<String> getFlags() {
    return flags;
  }

  public void setFlags(List<String> flags) {
    this.flags = flags;
  }
}

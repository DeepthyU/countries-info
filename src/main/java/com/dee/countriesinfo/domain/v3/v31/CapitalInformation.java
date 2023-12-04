/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.v3.v31;

import java.util.List;

public class CapitalInformation {

  private List<Double> latlng;

  public List<Double> getLatlng() {
    return latlng;
  }

  public void setLatlng(List<Double> latlng) {
    this.latlng = latlng;
  }
}

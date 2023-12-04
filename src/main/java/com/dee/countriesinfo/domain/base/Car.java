/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.base;

import java.util.List;

public class Car {
  private List<String> signs;
  private String side;

  public List<String> getSigns() {
    return signs;
  }

  public void setSigns(List<String> signs) {
    this.signs = signs;
  }

  public String getSide() {
    return side;
  }

  public void setSide(String side) {
    this.side = side;
  }
}

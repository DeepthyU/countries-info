/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.base;

public class NativeName {
  private String official;
  private String common;

  public String getOfficial() {
    return official;
  }

  public void setOfficial(String official) {
    this.official = official;
  }

  public String getCommon() {
    return common;
  }

  public void setCommon(String common) {
    this.common = common;
  }
}

/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.v2;

public class Flag {
  private String svg;
  private String png;

  public String getSvg() {
    return svg;
  }

  public void setSvg(String svg) {
    this.svg = svg;
  }

  public String getPng() {
    return png;
  }

  public void setPng(String png) {
    this.png = png;
  }
}

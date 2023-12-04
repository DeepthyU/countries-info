/***
 * Code taken from https://gitlab.com/restcountries/restcountries
 */
package com.dee.countriesinfo.domain.v2;

public class Maps {
    private String gmaps;
    private String openstreetmap;

    public String getGmaps() {
        return gmaps;
    }

    public void setGmaps(String gmaps) {
        this.gmaps = gmaps;
    }

    public String getOpenstreetmap() {
        return openstreetmap;
    }

    public void setOpenstreetmap(String openstreetmap) {
        this.openstreetmap = openstreetmap;
    }
}

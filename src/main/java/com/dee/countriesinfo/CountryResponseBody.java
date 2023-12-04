package com.dee.countriesinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Response body for /pdsorted query
 */
@Getter
@Setter
@AllArgsConstructor
public class CountryResponseBody {

    private String country;
    private double populationDensity;

}

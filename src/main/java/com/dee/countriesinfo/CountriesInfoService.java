package com.dee.countriesinfo;

import com.dee.countriesinfo.domain.v3.v31.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CountriesInfoService {

    public static final Logger log = LoggerFactory.getLogger(CountriesInfoService.class);

    private static final String URI = "https://restcountries.com/v3.1/all";

    public Country[] getCountries() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(URI, Country[].class);
        } catch ( HttpStatusCodeException ex)
        {
            log.error("getCountries failed:{}",ex.getStatusText());
        } catch (RestClientException ex){
            log.error("getCountries failed: countries server error");
        }
        return null;
    }
}

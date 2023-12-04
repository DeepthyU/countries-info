package com.dee.countriesinfo;

import com.dee.countriesinfo.domain.v3.v31.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;

@RestController()
@RequestMapping("/v1")
public class CountriesInfoController {

    public static final Logger log = LoggerFactory.getLogger(CountriesInfoController.class);
    private static final String REGION_ASIA = "Asia";

    private final CountriesInfoService service;

    public CountriesInfoController(CountriesInfoService countriesInforService) {
        this.service = countriesInforService;
    }


    @GetMapping("/pdsorted")
    public ResponseEntity<List<CountryResponseBody>> getPdSortedObjects(){
        log.debug("pdsorted begins");
        // query countries from uri
        Country[] countries = service.getCountries();
        // if an error occured during uri query, return 404
        if (null == countries){
            log.debug("pdsorted ends:no countries found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // compute the population density and return Name objects in descending order of population density
        List<CountryResponseBody> namesList = Arrays.stream(countries)
                .sorted((c1,c2)-> (int) (c2.getPopulation()/c2.getArea() - c1.getPopulation()/c1.getArea()))
                .map(c->new CountryResponseBody(c.getName().getCommon(),c.getPopulation()/c.getArea())).collect(Collectors.toList());
        log.debug("pdsorted ends");
        return ok(namesList);
    }

    @GetMapping("/mdfbordering")
    public ResponseEntity<Country> filterByMaxRegion(){
        log.debug("mdfbordering begins");
        // query countries from uri
        Country[] countries = service.getCountries();
        // if an error occured during uri query, return 404
        if (null == countries){
            log.debug("mdfbordering ends:no countries found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // create a map cca3Map, which maps three-letter-country-code(cca3) to Country object
        Map<String, Country> cca3Map = Arrays.stream(countries)
                .collect(Collectors.toMap(Country::getCca3, Function.identity()));
        // get list of countries whose region is Asia.
        List<Country> countriesList = Arrays.stream(countries)
                .filter(c->REGION_ASIA.equalsIgnoreCase(c.getRegion()))
                .collect(Collectors.toList());
        log.debug("mdfbordering : {} countries in asia", countriesList.size());
        Long maxRegionsCount=0L;
        Country maxRegionCountry=null;
        for(Country checkCountry:countriesList){
            if (null!=checkCountry.getBorders())
            {
                // find the number of countries in border whose region is NOT Asia
                Long regionsCount = checkCountry.getBorders().stream()
                        .map(c -> cca3Map.getOrDefault(c,new Country()).getRegion())
                        .filter(c-> (null!=c && !REGION_ASIA.equalsIgnoreCase(c)))
                        .collect(Collectors.counting());
                if(regionsCount>=maxRegionsCount) {
                    maxRegionsCount = regionsCount;
                    maxRegionCountry = checkCountry;
                }
            }
        }
        if (null != maxRegionCountry){
            log.debug("mdfbordering ends");
            return ok(maxRegionCountry);
        }
        log.debug("mdfbordering ends: no country found");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

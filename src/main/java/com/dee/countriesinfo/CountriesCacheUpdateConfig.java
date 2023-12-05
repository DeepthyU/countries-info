package com.dee.countriesinfo;

import com.dee.countriesinfo.domain.v3.v31.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class CountriesCacheUpdateConfig {

    private static final Logger log = LoggerFactory.getLogger(CountriesCacheUpdateConfig.class);

    private final CountriesInfoService countriesInfoService;

    public CountriesCacheUpdateConfig(CountriesInfoService countriesInfoService) {
        this.countriesInfoService = countriesInfoService;
    }

    @CacheEvict(value = "countriesData", allEntries = true)
    @Scheduled(fixedRate = 120000)
    public void updateCache() {
        log.info("updateCache invoked");
        Country[] countries = countriesInfoService.getCountries();
        log.debug("updateCache: {} countries in cache", null==countries?0:countries.length);
    }
}

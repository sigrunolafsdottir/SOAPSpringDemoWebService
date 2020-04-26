package com.example.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setId(1);
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        spain.setMovie("Casa del Papel");

        countries.put(spain.getName(), spain);

        Country poland = new Country();
        spain.setId(2);
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        poland.setMovie("Ida");

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setId(3);
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);
        uk.setMovie("Återstoden av dagen");

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }

    public Country findCountryById(int id) {
        Country c = null;
        for (Map.Entry<String, Country> entry : countries.entrySet()) {
            //System.out.println("id in list: "+entry.getValue().getId()+" id in "+id);
            if (entry.getValue().getId() == id){
                c = entry.getValue();
            }
        }
        return c;
    }
}
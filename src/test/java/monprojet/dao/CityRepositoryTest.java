package monprojet.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import monprojet.entity.City;
import monprojet.entity.Country;


@DataJpaTest
public class CityRepositoryTest {
    
    @Autowired
    private CountryRepository countryDAO;

    @Autowired
    private CityRepository cityDAO;

    @Test
    void onTrouveLePaysDesVilles(){
        City paris = cityDAO.findByName("Paris");
        Country france = countryDAO.findById(1).orElseThrow();
        assertEquals(paris.getCountry(), france, "Paris est en France");
    }

    @Test
    void onTrouveLesVillesDesPays(){
        City paris = cityDAO.findByName("Paris");
        Country france = countryDAO.findById(1).orElseThrow();
        assertTrue(france.getCities().contains(paris), "France contient Paris");
    }

}

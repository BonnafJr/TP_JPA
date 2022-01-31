package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import monprojet.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{
    
    public City findByName(String name); //recherche par nom d'attribut

}

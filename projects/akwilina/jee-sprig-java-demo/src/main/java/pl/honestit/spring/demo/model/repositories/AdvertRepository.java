package pl.honestit.spring.demo.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.honestit.spring.demo.model.domain.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long>{
	
	//ta metoda odwołuje się do bazy danych i na podstawie nazwy metody wnioskowane jet zaptanie do bazy danych
	List<Advert> findAllByOrderByPostedDesc(); 
}
package pl.honestit.spring.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.honestit.spring.demo.model.domain.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long>{

}
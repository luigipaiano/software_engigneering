package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Beneservizio;

@Repository
public interface BeneservizioRepository extends JpaRepository<Beneservizio, Integer> {
	
	@Query("SELECT b FROM beneservizio b WHERE categoria = :categoriaPR")
	List<Beneservizio> findByCategoria(@Param("categoriaPR") String categoriaPR);
		
}

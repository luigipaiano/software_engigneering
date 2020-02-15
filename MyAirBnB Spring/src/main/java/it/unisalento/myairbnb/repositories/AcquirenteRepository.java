package it.unisalento.myairbnb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Acquirente;

@Repository
public interface AcquirenteRepository extends JpaRepository <Acquirente, Integer> {
	
	 @Query("SELECT a FROM acquirente a WHERE idutente = :userID")
	 Acquirente findByIdAcquirente(@Param("userID") int userID);
	
}

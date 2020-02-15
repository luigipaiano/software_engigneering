package it.unisalento.myairbnb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Proponente;

@Repository
public interface ProponenteRepository extends JpaRepository<Proponente, Integer>{
	
    @Query("SELECT p FROM proponente p WHERE idutente = :userID")
    Proponente findByIdProponente(@Param("userID") int userID);
    

}

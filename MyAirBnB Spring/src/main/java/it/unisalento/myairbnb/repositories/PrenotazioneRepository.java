package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer>{
	
	@Query("SELECT p FROM prenotazione p WHERE idacquirente = :acquirenteID")
	List<Prenotazione> findByIdAcquirente(@Param("acquirenteID") int acquirenteID);
	
	 @Query("SELECT p FROM prenotazione p WHERE idproposta = :propostaID")
	 List<Prenotazione> findByIdProposta(@Param("propostaID") int propostaID);
	
	 //@Query("SELECT p1, p2 FROM proposta p1, prenotazione p2 WHERE p1.idproposta = :p2.idproposta AND p1.idproponente = :proponenteID")
	 //List<Prenotazione> findByIdProponente(@Param("proponenteID") int proponenteID);
	
	
}

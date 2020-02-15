package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Integer> {
	
	@Query("SELECT p FROM proposta p WHERE idbeneservizio = :beneservizioID")
	List<Proposta> findByIdBeneServizio(@Param("beneservizioID") int beneservizioID);
	
	 @Query("SELECT p FROM proposta p WHERE idproponente = :proponenteID")
	 List<Proposta> findByIdProponente(@Param("proponenteID") int proponenteID);
	 
	 @Query("SELECT p FROM proposta p WHERE stato = 1")
	 List<Proposta> findByApproved();
	 
	 @Query("SELECT p FROM proposta p WHERE stato = 0")
	 List<Proposta> findByNonApproved();
	 
	 @Modifying
	 @Query("UPDATE proposta p SET stato = 1 WHERE idproposta = :propostaID")
	 public void approvaProposta(@Param("propostaID") int propostaID);
	 
	 
	 
}


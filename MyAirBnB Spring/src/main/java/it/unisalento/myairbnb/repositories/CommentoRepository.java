package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Commento;

@Repository
public interface CommentoRepository extends JpaRepository<Commento, Integer>{
	
	
	@Query("SELECT c FROM commento c WHERE idacquirente = :acquirenteID")
	List<Commento> findByIdAcquirente(@Param("acquirenteID") int acquirenteID);
	
	 @Query("SELECT c FROM commento c WHERE idproposta = :propostaID")
	 List<Commento> findByIdProposta(@Param("propostaID") int propostaID);
	 
	 @Modifying
	 @Query("DELETE FROM commento c WHERE idproposta = :propostaID")
	 public void deleteCommentoByIdProposta(@Param("propostaID") int propostaID);
	
}
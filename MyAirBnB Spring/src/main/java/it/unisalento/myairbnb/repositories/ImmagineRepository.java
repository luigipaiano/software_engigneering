package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Immagine;

@Repository
public interface ImmagineRepository extends JpaRepository<Immagine, Integer>{
	
	@Query("SELECT i FROM immagine i WHERE idproposta = :propostaID")
	List<Immagine> findByIdProposta(@Param("propostaID") int propostaID);
	
	 @Modifying
	 @Query("DELETE FROM immagine i WHERE idproposta = :propostaID")
	 public void deleteImmagineByIdProposta(@Param("propostaID") int propostaID);

}
package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
 
	@Query("SELECT p FROM pagamento p WHERE idprenotazione = :prenotazioneID")
	List<Pagamento> findByIdPrenotazione(@Param("prenotazioneID") int prenotazioneID);
	
	
}

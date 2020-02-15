package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.unisalento.myairbnb.entities.Notifica;

@Repository
public interface NotificaRepository extends JpaRepository<Notifica, Integer>{
	
	
	@Query("SELECT n FROM notifica n WHERE idproposta = :propostaID")
	List<Notifica> findByIdProposta(@Param("propostaID") int propostaID);
	
	@Query("SELECT n FROM notifica n WHERE idacquirente = :acquirenteID ORDER BY data DESC")
	List<Notifica> findByIdAcquirente(@Param("acquirenteID") int acquirenteID);
	
	@Query("SELECT n FROM notifica n WHERE idproponente = :proponenteID ORDER BY data DESC")
	List<Notifica> findByIdProponente(@Param("proponenteID") int proponenteID);
	
	@Query("SELECT n FROM notifica n WHERE tipo = :tipoID")
	List<Notifica> findTipo(@Param("tipoID") int tipoID);
	

}

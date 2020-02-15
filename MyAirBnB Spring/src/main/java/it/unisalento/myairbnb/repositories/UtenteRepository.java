package it.unisalento.myairbnb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	
	
	@Query("SELECT u FROM Utente u WHERE u.username=:username AND u.password=:password")
	public Utente findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

	public Utente findByUsername(String username);  
	public Utente findByEmail(String email);
	
	
	}
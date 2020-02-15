package it.unisalento.myairbnb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
    @Query("SELECT a FROM admin a WHERE idutente = :userID")
    Admin findByIdAmin(@Param("userID") int userID);
    
	
}

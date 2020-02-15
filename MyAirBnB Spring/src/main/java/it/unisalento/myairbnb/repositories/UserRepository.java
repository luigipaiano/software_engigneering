package it.unisalento.myairbnb.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.unisalento.myairbnb.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public List<User> findByName (String name, Sort sort);  //in questa maniera spring riesce a capire la query da eseguire sul db in base al nome del metodo (name)
	
	
	@Query("select u from User u where name=:name")
	public List<User> findByNameUsingQuery(@Param("name")String name);
	
	public List<User> findByNameAndSurname(String name, String surname);
	
	@Query("select u from User u where u.name=:name AND u.surname=:surname")
	public List<User> findByNameAndSurnameUsingQuery(@Param("name") String name, @Param("surname") String surname);


}

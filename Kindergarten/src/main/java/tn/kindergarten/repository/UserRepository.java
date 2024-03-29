package tn.kindergarten.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.kindergarten.entities.User;




@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);
	
	@Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.active = TRUE WHERE a.username = ?1")
    public int activeUser(String username);
	
	@Query("select DISTINCT u from User u ")
    public List<User> getAllUsers();
	
	@Query("select DISTINCT u from User u "
			+ "where u.id=:userId")
    public User getUserById(@Param("userId")int userId);
	
	
}

package tn.kindergarten.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.ERole;
import tn.kindergarten.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long>  {

	Optional<Role> findByName(ERole name);
}

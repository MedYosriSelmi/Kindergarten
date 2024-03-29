package tn.kindergarten.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Bill;



@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
	@Query("select DISTINCT e from Bill e "
			+ "join e.user m "
			+ "where m.id=:userId")
public List<Bill> getAllBillByUser(@Param("userId")int userId);

	@Query("SELECT count (*)  from Child c where c.user.id=:user AND c.kindergarten.id=:kindergarten")
	public long getNumberOfChildForUserInKinderJPQL(@Param("user") int user,@Param("kindergarten") int kindergarten);


	@Query("select DISTINCT e from Bill e "
			+ "join e.kindergarten m "
			+ "where m.id=:kinderId")
public List<Bill> getAllBillBykinder(@Param("kinderId")int kinderId);
	
	@Query("select DISTINCT e from Bill e "
			+ "join e.kindergarten k  "
			+"join e.user u "
			+ "where  u.id =:userId   AND  k.id=:kinderId  ")
public List<Bill> getAllBillForUserInKinder(   @Param("userId")int userId , @Param("kinderId")int kinderId  );
	@Modifying
	@Transactional
	@Query("UPDATE Bill set TotalPrice=:amount where user=:user_id")
	public void setFacture_PRICE(@Param("user_id") int user_id ,@Param("amount") float amount);
}


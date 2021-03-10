package tn.kindergarten.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Comment;



@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}

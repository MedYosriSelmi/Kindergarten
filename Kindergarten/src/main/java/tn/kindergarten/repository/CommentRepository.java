package tn.kindergarten.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.kindergarten.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query("SELECT c.Description FROM Comment c " + "where (c.sub.id=:subjectId) " + "ORDER BY creationDate")
	public Set<String> getCommentBySubjectId(@Param("subjectId") int subjectId);

	@Query("SELECT c.Description FROM Comment c " + "where (c.comment.id=:parentId) " + "ORDER BY creationDate")
	public Set<String> getCommentByParentId(@Param("parentId") int parentId);

}

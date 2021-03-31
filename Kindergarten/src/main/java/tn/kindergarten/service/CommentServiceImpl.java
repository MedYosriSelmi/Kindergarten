package tn.kindergarten.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Comment;
import tn.kindergarten.entities.Subject;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.CommentRepository;
import tn.kindergarten.repository.SubjectRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void addParentComment(Comment comment, int subjectId, int userId) {

		Subject s = subjectRepository.findById(subjectId).orElse(null);
		comment.setSub(s);
		User u = userRepository.findById(userId).orElse(null);
		comment.setUser(u);
		commentRepository.save(comment);

	}

	@Override
	public void addChildComment(Comment comment, int subjectId, int userId, int parentId) {

		Subject s = subjectRepository.findById(subjectId).orElse(null);
		comment.setSub(s);
		User u = userRepository.findById(userId).orElse(null);
		comment.setUser(u);
		Comment c = commentRepository.findById(parentId).orElse(null);
		comment.setComment(c);
		commentRepository.save(comment);

	}

	@Override
	public Set<String> getCommentBySubjectId(int subjectId) {

		return commentRepository.getCommentBySubjectId(subjectId);
	}

	@Override
	public Set<String> getCommentByParentId(int parentId) {

		return commentRepository.getCommentByParentId(parentId);
	}

	@Override
	public void deleteComment(int commentId) {

		commentRepository.deleteById(commentId);

	}

	@Override
	public void updateComment(Comment c, int commentId) {
		Comment comment = commentRepository.findById(commentId).get();
		comment.setDescription(c.getDescription());
		commentRepository.save(comment);

	}

}

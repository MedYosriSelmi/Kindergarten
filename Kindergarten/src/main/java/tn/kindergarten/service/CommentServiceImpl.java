package tn.kindergarten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Comment;
import tn.kindergarten.repository.CommentRepository;
import tn.kindergarten.repository.SubjectRepository;

@Service
public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public void addComment(Comment comment){
		
		commentRepository.save(comment);
		
	}


	@Override
	public List<Comment> getAllComments() {
		return (List<Comment>) commentRepository.findAll();
	}


	@Override
	public void deleteComment(int commentId) {
		
		commentRepository.deleteById(commentId);
		
	}
	
	@Override
	public void updateComment(Comment c, int commentId) {
		Comment comment = commentRepository.findById(commentId).get();
		comment.setDateDelivered(c.getDateDelivered());
		comment.setDescription(c.getDescription());
		commentRepository.save(comment);
		
	}
	
	

}

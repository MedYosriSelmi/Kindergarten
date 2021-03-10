package tn.kindergarten.service;



import java.util.List;

import tn.kindergarten.entities.Comment;

public interface ICommentService {
	
	public void addComment(Comment comment);
	public List<Comment> getAllComments();
	public void deleteComment(int commentId);
	public void updateComment(Comment comment, int commentId);
}

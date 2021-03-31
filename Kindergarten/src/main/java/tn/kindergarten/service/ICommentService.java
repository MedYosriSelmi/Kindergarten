package tn.kindergarten.service;

import java.util.Set;

import tn.kindergarten.entities.Comment;

public interface ICommentService {

	public void addParentComment(Comment comment, int subjectId, int userId);

	public void addChildComment(Comment comment, int subjectId, int userId, int parentId);

	public Set<String> getCommentBySubjectId(int subjectId);

	public Set<String> getCommentByParentId(int parentId);

	public void deleteComment(int commentId);

	public void updateComment(Comment comment, int commentId);
}

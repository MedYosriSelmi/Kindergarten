package tn.kindergarten.service;

import java.util.List;
import java.util.Set;

import tn.kindergarten.entities.Subject;

public interface ISubjectService {

	public void addSubject(Subject subject, int userId);

	public List<Subject> getAllSubjects();

	public void deleteSubjectById(int subjectId);

	public void updateSubject(Subject subject, int subjectId);

	public Set<Subject> findtop5ByOrderByCreationDateDesc();

	public void approveSubject(int subjectId);

	public List<Subject> getSubjectByUserId(int userId);

}

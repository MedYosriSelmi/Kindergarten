package tn.kindergarten.service;

import java.util.Date;
import java.util.List;

import tn.kindergarten.entities.Subject;

public interface ISubjectService {

	public void addSubject(Subject subject);
	public Subject getSubject(int subjectId);
	public Date getDateSubject(int subjectId);
	public List<Subject> getAllSubjects();
	public void deleteSubjectById(int subjectId);
	public void updateSubject(Subject subject, int subjectId);
	
}

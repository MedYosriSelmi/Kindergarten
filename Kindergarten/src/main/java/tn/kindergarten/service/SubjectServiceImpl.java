package tn.kindergarten.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Subject;
import tn.kindergarten.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public void addSubject(Subject subject){
		
		subjectRepository.save(subject);
		
		
	}
	
	@Override
	public Subject getSubject(int subjectId){
		
		return subjectRepository.findById(subjectId).orElse(null);
	
	}
	
	@Override
	public Date getDateSubject(int subjectId){
		
		Subject s = subjectRepository.findById(subjectId).orElse(null);
		return s.getDateSubject();
		
	}
	
	@Override
	public List<Subject> getAllSubjects(){
		
		return (List<Subject>) subjectRepository.findAll();
		
	}
	
	@Override
	public void deleteSubjectById(int subjectId){
		
		subjectRepository.deleteById(subjectId);
		
	}
	
	@Override
	public void updateSubject(Subject c, int subjectId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		subject.setDescription(c.getDescription());
		subject.setDateSubject(c.getDateSubject());
		subject.setName(c.getName());
		subject.setPhoto(c.getPhoto());
		subjectRepository.save(subject);
		
	}
}

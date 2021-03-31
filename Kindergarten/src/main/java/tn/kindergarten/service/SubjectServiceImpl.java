package tn.kindergarten.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Subject;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.SubjectRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	EmailService emailService;
	@Autowired
	UserRepository userRepository;

	@Override
	public void addSubject(Subject subject, int userId) {

		User u = userRepository.findById(userId).orElse(null);
		subject.setUser(u);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(subject.getUser().getEmail());
		mailMessage.setSubject("!! Subject Created and waiting to be approved !!");
		mailMessage.setFrom("kinder.garten0206@gmail.com");
		mailMessage.setText(" Dear Mr " + subject.getUser().getFirstName() + "  " + subject.getUser().getLastName()
				+ "    your have a new subject created in " + subject.getCreationDate()
				+ "  and waiting to be approved  ");

		emailService.sendEmail(mailMessage);
		subjectRepository.save(subject);

	}

	@Override
	public List<Subject> getAllSubjects() {

		return (List<Subject>) subjectRepository.findAll();

	}

	@Override
	public void deleteSubjectById(int subjectId) {

		subjectRepository.deleteById(subjectId);

	}

	@Override
	public void updateSubject(Subject c, int subjectId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		subject.setDescription(c.getDescription());
		subject.setName(c.getName());
		subject.setPhoto(c.getPhoto());
		subjectRepository.save(subject);

	}

	@Override
	public Set<Subject> findtop5ByOrderByCreationDateDesc() {
		return subjectRepository.findTop5ByOrderByCreationDateDesc();
	}

	@Override
	public void approveSubject(int subjectId) {
		Subject s = subjectRepository.findById(subjectId).orElse(null);
		s.setApproved(true);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(s.getUser().getEmail());
		mailMessage.setSubject("!! Subject approved !!");
		mailMessage.setFrom("kinder.garten0206@gmail.com");
		mailMessage.setText(" Dear Mr " + s.getUser().getFirstName() + "  " + s.getUser().getLastName()
				+ "    your subject created in " + s.getCreationDate() + "  has been approved ");

		emailService.sendEmail(mailMessage);

	}

	@Override
	public List<Subject> getSubjectByUserId(int userId) {

		return subjectRepository.getSubjectByUserId(userId);
	}

}

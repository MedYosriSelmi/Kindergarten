package tn.kindergarten.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Message;
import tn.kindergarten.entities.User;
import tn.kindergarten.repository.MessageRepository;
import tn.kindergarten.repository.UserRepository;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	MessageRepository messageRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void addMessage(Message message, int senderId, int recieverId) {

		User u1 = userRepository.findById(senderId).orElse(null);
		User u2 = userRepository.findById(recieverId).orElse(null);
		message.setSender(u1);
		message.setReciever(u2);
		messageRepository.save(message);

	}

	@Override
	public List<Message> getAllMessages() {
		return (List<Message>) messageRepository.findAll();
	}

	@Override
	public void deleteMessage(int messageId) {

		messageRepository.deleteById(messageId);

	}

	@Override
	public void updateMessage(Message m, int MessageId) {
		Message message = messageRepository.findById(MessageId).get();
		message.setDescription(m.getDescription());
		messageRepository.save(message);

	}

	@Override
	public String verifyBadWords(String sentence) {

		List<String> badWords = Arrays.asList("fuck", "shit", "hoe", "bitch");
		String[] words = sentence.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			if (badWords.contains(words[i]))
				words[i] = badWordsToStars(words[i]);
		}
		return String.join(" ", words);
	}

	public String badWordsToStars(String badwords) {

		String s = "";
		for (int i = 0; i < badwords.length(); i++) {
			s = s + "*";
		}
		return s;
	}

	@Override
	public List<String> getDiscussion(int senderId, int recieverId) {

		return messageRepository.getDiscussion(senderId, recieverId);
	}

	@Override
	public Set<String> searchStringInDiscussion(String string, int senderId, int recieverId) {

		return messageRepository.searchStringInDiscussion(string, senderId, recieverId);
	}

}

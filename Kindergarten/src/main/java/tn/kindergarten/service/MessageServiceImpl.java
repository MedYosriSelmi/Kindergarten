package tn.kindergarten.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.Message;
import tn.kindergarten.repository.MessageRepository;

@Service
public class MessageServiceImpl implements IMessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	@Override
	public void addMessage(Message message){
		
		messageRepository.save(message);
		
	}


	@Override
	public List<Message> getAllMessages() {
		return (List<Message>) messageRepository.findAll();
	}


	@Override
	public void deleteMessage(int messageId){
		
		messageRepository.deleteById(messageId);
		
	}
	
	@Override
	public void updateMessage(Message m, int MessageId) {
		Message message = messageRepository.findById(MessageId).get();
		message.setDateDelivered(m.getDateDelivered());
		message.setDescription(m.getDescription());
		messageRepository.save(message);
		
	}

}

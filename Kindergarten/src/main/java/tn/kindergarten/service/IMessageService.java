package tn.kindergarten.service;

import java.util.List;

import tn.kindergarten.entities.Message;

public interface IMessageService {
	
	public void addMessage(Message message);
	public List<Message> getAllMessages();
	public void deleteMessage(int messageId);
	public void updateMessage(Message message, int MessageId);

}


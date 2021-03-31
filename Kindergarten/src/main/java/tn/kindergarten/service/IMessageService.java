package tn.kindergarten.service;

import java.util.List;
import java.util.Set;

import tn.kindergarten.entities.Message;

public interface IMessageService {

	public void addMessage(Message message, int senderId, int recieverId);

	public List<Message> getAllMessages();

	public void deleteMessage(int messageId);

	public void updateMessage(Message message, int MessageId);

	public String verifyBadWords(String sentence);

	public List<String> getDiscussion(int senderId, int recieverId);

	public Set<String> searchStringInDiscussion(String string, int senderId, int recieverId);

}

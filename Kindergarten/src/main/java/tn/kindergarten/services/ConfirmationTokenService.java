package tn.kindergarten.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.kindergarten.entities.ConfirmationToken;
import tn.kindergarten.repository.ConfirmationTokenRepository;



@Service
public class ConfirmationTokenService {
	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;

	public void saveConfiramationtoken(	ConfirmationToken token){
		confirmationTokenRepository.save(token);
	}

	public ConfirmationToken getToken(String token) {
	    return confirmationTokenRepository.findByToken(token);
	}

	public int setConfirmedAt(String token) {
	    return confirmationTokenRepository.updateConfirmedAt(
	            token, LocalDateTime.now());
	}
	
}

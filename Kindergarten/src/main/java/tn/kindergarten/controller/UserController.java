package tn.kindergarten.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;

import tn.kindergarten.entities.User;
import tn.kindergarten.repository.UserRepository;
import tn.kindergarten.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class UserController {

	
	@Autowired
	UserRepository userrep1;
	@Autowired
	UserDetailsServiceImpl use;
	
	@PostMapping("/register")
    public String register(@RequestBody() User user) throws IOException, NexmoClientException {
		
      NexmoClient client = NexmoClient.builder().apiKey("490dd4b5").apiSecret("pB3csqChOmGhVWiq").build();
      
      TextMessage message = new TextMessage("Vonage APIs",
              "21621254784",
              "un nouveau compte utilisateur a ete cree"
      );

      SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

      if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
          System.out.println("Message sent successfully.");
      }
        return use.saveUser(user);
    }
	
	 @GetMapping("/confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return use.confirmToken(token);
	    }
	
	 @PutMapping(value = "/affecter/{iduser}/{idRole}") 
	    public void affecter(@PathVariable("iduser")long iduser,@PathVariable("idRole") int idRole) {
	    	
			use.affecterUserARole(iduser, idRole);	
	    }
}

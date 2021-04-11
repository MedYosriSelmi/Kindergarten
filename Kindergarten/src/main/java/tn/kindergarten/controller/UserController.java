package tn.kindergarten.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		
     /* NexmoClient client = NexmoClient.builder().apiKey("490dd4b5").apiSecret("pB3csqChOmGhVWiq").build();
      
      TextMessage message = new TextMessage("Vonage APIs",
              "21621254784",
              "un nouveau compte utilisateur a ete cree"
      );

      SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

      if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
          System.out.println("Message sent successfully.");
      }*/
        return use.saveUser(user);
    }
	
	 @GetMapping("/confirm")
	    public String confirm(@RequestParam("token") String token) {
	        return use.confirmToken(token);
	    }
	
	 @PutMapping(value = "/affecter/{iduser}/{idRole}") 
	    public void affecter(@PathVariable("iduser")int iduser,@PathVariable("idRole") int idRole) {
	    	
			use.affecterUserARole(iduser, idRole);	
	    }
	 
	 @GetMapping("/getAllUsers")
	    @ResponseBody
		public List<User> getAllUsers() {

			return use.getAllUsers();
		}
	 
	 @GetMapping("/getUserById/{idUser}")//done
	    @ResponseBody
		public User getUserById(@PathVariable("idUser") int userId) {

			return use.getUserById(userId);
		}
	 
	 @PostMapping("/profile/upload")
	    @ResponseBody
	    public User  uploadPicture (@RequestParam("file") @Nullable MultipartFile file, @RequestParam("user") int iduser ) {
	        User user =use.findById(iduser);
	        if(file==null) {
	            user.setPhoto("defaultPic.png");
	            use.saveUser(user);
	        }else {
	            try {
	                ClassLoader classLoader = getClass().getClassLoader();
	                String path =  classLoader.getResource(".").getFile();
	               
	                File f = new File("C:\\Users\\Med Yosri\\git\\Kindergarten\\images\\" + file.getOriginalFilename());
	                file.transferTo(f);
	               user.setPhoto("image"+file.getOriginalFilename());
	               use.saveUser(user);
	            } catch (IllegalStateException e) {
	           
	                e.printStackTrace();
	            } catch (IOException e) {
	            
	                e.printStackTrace();
	            }
	        }

	        return(user);
	    }
}

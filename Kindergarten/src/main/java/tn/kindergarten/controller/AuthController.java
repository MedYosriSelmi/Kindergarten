package tn.kindergarten.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.kindergarten.entities.ERole;
import tn.kindergarten.entities.Role;
import tn.kindergarten.entities.User;
import tn.kindergarten.payload.request.LoginRequest;
import tn.kindergarten.payload.request.SignupRequest;
import tn.kindergarten.payload.response.JwtResponse;
import tn.kindergarten.payload.response.MessageResponse;
import tn.kindergarten.repository.RoleRepository;
import tn.kindergarten.repository.UserRepository;
import tn.kindergarten.security.jwt.JwtUtils;
import tn.kindergarten.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	//@Autowired
	//PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Email is already in use!"));
//		}
//
//		// Create new user's account
//		User user = new User(signUpRequest.getUsername(), 
//							 signUpRequest.getEmail(),
//							 encoder.encode(signUpRequest.getPassword()));
//
//		Set<String> strRoles = signUpRequest.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//					break;
//				case "dir":
//					Role modRole = roleRepository.findByName(ERole.ROLE_DIRECTOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//                	break;
//				case "manager":
//					Role managerRole = roleRepository.findByName(ERole.ROLE_CHILDCAREMANAGER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(managerRole);
//
//					break;	
//				case "doctor":
//					Role medecinRole = roleRepository.findByName(ERole.ROLE_DOCTOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(medecinRole);
//					break;	
//				case "driver":
//					Role driverRole = roleRepository.findByName(ERole.ROLE_DRIVER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(driverRole);
//					break;		
//				default:
//					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(userRole);
//				}
//			});
//		}
//
//		user.setRoles(roles);
//		userRepository.save(user);
//
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}
}



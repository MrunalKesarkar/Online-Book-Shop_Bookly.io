package com.bookly.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookly.custom_exceptions.ResourceNotFoundException;
import com.bookly.dao.UserDao;
import com.bookly.dto.RegisterDTO;
import com.bookly.dto.SigninRequest;
import com.bookly.dto.SigninResponse;
import com.bookly.entities.User;
import com.bookly.security.JwtUtils;
import com.bookly.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private AuthenticationManager authMgr;

	
	@PostMapping("/register")
	public ResponseEntity<?> addNewUser(@RequestBody RegisterDTO dto){
		return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(dto));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody 
			@Valid SigninRequest request) {
		System.out.println("in sign in" + request);
		
		UsernamePasswordAuthenticationToken token=new 
				UsernamePasswordAuthenticationToken(request.getEmail(), 
						request.getPassword());
		//invoke auth mgr's authenticate method;
		User user = userDao.findByEmail(request.getEmail()).orElseThrow(()-> new ResourceNotFoundException("Invalid Email Address"));
		Authentication verifiedToken = authMgr.authenticate(token);
		//=> auth successful !
		System.out.println(verifiedToken.getPrincipal().getClass());//custom user details object
		//create JWT n send it to the clnt in response
		SigninResponse resp=new SigninResponse
				(jwtUtils.generateJwtToken(verifiedToken),
				"Successful Auth!!!!",user.getFirstName(), user.getRole().toString());
		return ResponseEntity.
				status(HttpStatus.CREATED).body(resp);
	}
}

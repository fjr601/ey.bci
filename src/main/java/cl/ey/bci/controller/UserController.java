package cl.ey.bci.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.ey.bci.entity.User;
import cl.ey.bci.repository.UserRepository;
import cl.ey.bci.response.Message;
import cl.ey.bci.response.Response;
import cl.ey.bci.util.Constant;
import cl.ey.bci.util.Util;

@RestController
public class UserController {
	@Autowired
	private UserRepository _userRepository;

	@GetMapping("/")
	public String health() {
		DateFormat df = new SimpleDateFormat("EEEE, d MMM yyyy, HH:mm:ss");
		return String.format("Desafío BCI: %s", df.format(new Date()));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable UUID id) {
		try {
			User user = _userRepository.findById(id);
			if (user != null) {
				return ResponseEntity.ok(user);
			}
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message(Constant.USER_NOT_EXIST));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Message(Constant.INTERNAL_ERROR));
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		try {
			if (_userRepository.findByEmail(user.getEmail()) != null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message(Constant.USER_EXIST));
			}
			if (!Util.validateEmail(user.getEmail())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(Constant.ERROR_EMAIL));
			}
			if (!Util.validatePassword(user.getPassword())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(Constant.ERROR_PASSWORD));
			}
			user.createDataUser();
			User createdUser = _userRepository.save(user);
			return ResponseEntity.ok(new Response(createdUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Message(Constant.INTERNAL_ERROR));
		}
	}

	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		try {
			User existingUser = _userRepository.findById(user.getId());
			if (existingUser == null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new Message(Constant.USER_NOT_EXIST));
			}
			if (user.getName() != null) {
				existingUser.setName(user.getName());
			}
			if (user.getEmail() != null) {
				existingUser.setEmail(user.getEmail());
			}
			if (user.getPassword() != null && Util.validatePassword(user.getPassword())) {
				existingUser.setPassword(user.getPassword());
			} else if (user.getPassword() != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message(Constant.ERROR_PASSWORD));
			}
			existingUser.setModified(new Date());
			User savedUser = _userRepository.save(existingUser);
			return ResponseEntity.ok(new Response(savedUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Message(Constant.INTERNAL_ERROR));
		}
	}

}

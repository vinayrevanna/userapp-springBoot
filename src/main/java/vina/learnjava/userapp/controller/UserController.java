package vina.learnjava.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vina.learnjava.userapp.model.User;
import vina.learnjava.userapp.service.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
    
    public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
    
    @Autowired
	private  final UserRepository userRepository;
 
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id){
    		userRepository.deleteById((long) id);
        	System.out.println("delete called");
    }
}

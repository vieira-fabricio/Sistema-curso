package br.com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.model.User;
import br.com.springboot.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User usuario(@PathVariable("id") Long id){
		Optional<User> userFind = this.userRepository.findById(id);
		
		if(userFind.isPresent()) {
			return userFind.get();
		}
		return null;
	}

	@PostMapping("/")
	public User usuario(@RequestBody User usuario) {
		
		return this.userRepository.save(usuario);
	}
	
	@GetMapping("/list")
	public List<User> list() {
		
		return userRepository.findAll();
	} 

	@DeleteMapping("/{id}")
    public User deletarPeloId(@PathVariable("id") Long id) {

        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        } 
        return null;
    }

	 @GetMapping("/findByName/{name}")
	 public List<User> listMoreThanList(@PathVariable("name") String name) {
		
		return this.userRepository.findByNameIgnoreCase(name);
	}

	@GetMapping("/findByid/{id}")
	public List<User> listGreaterThan(@PathVariable("id") Long id){

		return this.userRepository.findByIdGreaterThan(id);
	}
}

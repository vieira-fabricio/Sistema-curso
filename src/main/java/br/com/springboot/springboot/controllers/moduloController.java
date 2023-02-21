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

import br.com.springboot.springboot.model.Modulo;
import br.com.springboot.springboot.repository.moduloRepository;

@RestController
@RequestMapping("/modulos")
public class moduloController {
    @Autowired
    private moduloRepository moduloRepository;

    @GetMapping("/{id}")
    public Modulo modulo(@PathVariable("id") Long id){

        Optional<Modulo> moduloFind = this.moduloRepository.findById(id);
        
        if(moduloFind.isPresent()) {
			return moduloFind.get();
		}
		return null;
    }

    @PostMapping("/")
    public Modulo modulo(@RequestBody Modulo modulo){
        
        return this.moduloRepository.save(modulo);
    }

    @GetMapping("/list")
	public List<Modulo> list() {
		
		return this.moduloRepository.findAll();
	}

    @DeleteMapping("/{id}")
    public Modulo deletarPeloId(@PathVariable("id") Long id) {

        if(moduloRepository.existsById(id)){
            moduloRepository.deleteById(id);
        } 
        return null;
    }
    
}

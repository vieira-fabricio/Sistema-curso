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


import br.com.springboot.springboot.model.Curso;
import br.com.springboot.springboot.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/{id}")
    public Curso curso(@PathVariable("id") Long id){

        Optional<Curso> cursoFind = this.cursoRepository.findById(id);
        
        if(cursoFind.isPresent()) {
			return cursoFind.get();
		}
		return null;
    }

    @PostMapping("/")
    public Curso curso(@RequestBody Curso curso){
        
        return this.cursoRepository.save(curso);
    }

    @GetMapping("/list")
	public List<Curso> list() {
		
		return this.cursoRepository.findAll();
	}

    @GetMapping("/findByName/{name}")
	 public List<Curso> listMoreThanList(@PathVariable("name") String name) {
		
		return this.cursoRepository.findByNameIgnoreCase(name);
	}

	@GetMapping("/findByid/{id}")
	public List<Curso> listGreaterThan(@PathVariable("id") Long id){

		return this.cursoRepository.findByIdGreaterThan(id);
	}

    @DeleteMapping("/{id}")
    public Curso deletarPeloId(@PathVariable("id") Long id) {

        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
        } 
        return null;
    }
    
}

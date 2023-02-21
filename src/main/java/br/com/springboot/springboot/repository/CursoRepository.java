package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    public List<Curso> findByIdGreaterThan(Long id);
    public List<Curso> findByNameIgnoreCase(String name);

}

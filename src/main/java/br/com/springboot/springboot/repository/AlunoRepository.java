package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
    public List<Aluno> findByIdGreaterThan(Long id);
    public List<Aluno> findByNameIgnoreCase(String name);

}

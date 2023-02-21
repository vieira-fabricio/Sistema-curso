package br.com.springboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.Modulo;

public interface moduloRepository extends JpaRepository<Modulo, Long>{
    
}

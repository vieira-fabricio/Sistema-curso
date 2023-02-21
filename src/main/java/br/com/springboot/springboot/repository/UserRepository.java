package br.com.springboot.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.springboot.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

    public List<User> findByIdGreaterThan(Long id);
    public List<User> findByNameIgnoreCase(String name);
}

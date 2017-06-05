package br.com.suntech.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suntech.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByNameContainingOrEmailContainingOrUsernameContainingAllIgnoringCase(String name,
			String email, String username);

}

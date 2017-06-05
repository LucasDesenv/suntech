package br.com.suntech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suntech.domain.IUser;
import br.com.suntech.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<? extends IUser> findByFilter(String filter) {
		return userRepository.findByNameContainingOrEmailContainingOrUsernameContainingAllIgnoringCase(filter,filter,filter);
	}

}

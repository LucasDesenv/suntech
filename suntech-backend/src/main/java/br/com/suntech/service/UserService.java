package br.com.suntech.service;

import java.util.List;

import br.com.suntech.domain.IUser;

public interface UserService {

	List<? extends IUser> findByFilter(String filter);

}

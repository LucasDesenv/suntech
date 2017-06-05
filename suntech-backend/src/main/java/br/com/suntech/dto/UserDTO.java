package br.com.suntech.dto;

import java.util.Date;

import br.com.suntech.domain.IUser;

public class UserDTO implements IUser {
	private static final long serialVersionUID = 7646246790240510315L;
	private Integer id;
	private String username;
	private String password;
	private boolean enabled;
	private Date registerDate;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
	public UserDTO() {
	}
	
	public UserDTO(IUser iUser) {
		this.id = iUser.getId();
		this.username = iUser.getUsername();
		this.password = iUser.getPassword();
		this.enabled = iUser.isEnabled();
		this.registerDate = iUser.getRegisterDate();
		this.name = iUser.getName();
		this.surname = iUser.getSurname();
		this.email = iUser.getEmail();
		this.phone = iUser.getPhone();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + "]";
	}

}

package br.com.suntech.domain;

import java.io.Serializable;
import java.util.Date;

public interface IUser extends Serializable{
	public Integer getId();

	public String getUsername();

	public String getPassword();

	public boolean isEnabled();

	public Date getRegisterDate();

	public String getName();

	public String getSurname();

	public String getEmail();

	public String getPhone();
}

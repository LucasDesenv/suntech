package br.com.suntech.dto;

import java.util.Date;

import br.com.suntech.domain.IUser;

public class UserDTO implements IUser {

    private static final long serialVersionUID = 2751381371493200731L;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Integer id;
    private String password;
    private boolean enabled;
    private Date registerDate;
    private String phone;

    public UserDTO() {
    }

    public UserDTO(IUser iUser) {
        this.username = iUser.getUsername();
        this.name = iUser.getName();
        this.surname = iUser.getSurname();
        this.email = iUser.getEmail();
        this.id = iUser.getId();
        this.enabled = iUser.isEnabled();
        this.registerDate = iUser.getRegisterDate();
        this.password = iUser.getPassword();
        this.phone = iUser.getPhone();
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserDTO [username=" + username + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
    }

}

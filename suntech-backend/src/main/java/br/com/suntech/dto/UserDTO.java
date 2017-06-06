package br.com.suntech.dto;

import java.io.Serializable;

import br.com.suntech.domain.IUser;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2751381371493200731L;
    private String username;
    private String name;
    private String surname;
    private String email;
    private Integer id;

    public UserDTO() {
    }

    public UserDTO(IUser iUser) {
        this.username = iUser.getUsername();
        this.name = iUser.getName();
        this.surname = iUser.getSurname();
        this.email = iUser.getEmail();
        this.id = iUser.getId();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDTO [username=" + username + ", name=" + name + ", surname=" + surname + ", email=" + email + "]";
    }

}

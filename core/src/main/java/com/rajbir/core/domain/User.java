package com.rajbir.core.domain;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sony on 30-08-2017.
 */
//@Entity(name="user")

public class User {
    public Long id;

    @NotNull
    public String name;

    @NotNull
    @Email(message="{email.valid}")
    public String email;

    //    The @Size annotation has message set to a string whose value is
//    wrapped in curly braces. If you left the curly braces out, the value given to message
//    would be the error message displayed to the user. But by using curly braces, you designate
//    a property in a properties file that contains the actual message.
    @NotNull
    @Size(min=2, max=30, message="{password.size}")
    public String password;

    public User() {
    }

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
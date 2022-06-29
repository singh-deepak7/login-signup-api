package com.login.signup.model;
import javax.persistence.*;

@Entity
@Table(name = "user_management", schema = "mysvc")
public class UserManagement {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean activeSw;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "active_sw")
    public boolean isActiveSw() {
        return activeSw;
    }

    public void setActiveSw(boolean activeSw) {
        this.activeSw = activeSw;
    }
}

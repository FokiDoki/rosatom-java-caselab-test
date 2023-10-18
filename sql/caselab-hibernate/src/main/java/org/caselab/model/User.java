package org.caselab.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String name;
    private String password;

    @Column(name = "reg_date")
    private LocalDate registrationDate;

    @Column(name = "is_banned")
    private boolean isBanned;
    private String ip;


    public User(Long id, String name, String password, LocalDate registrationDate, boolean isBanned, String ip) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isBanned = isBanned;
        this.ip = ip;
    }

    public User() {

    }

    public User(String name, String password, LocalDate registrationDate, boolean isBanned, String ip) {
        this.name = name;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isBanned = isBanned;
        this.ip = ip;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String  ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", \nname='" + name + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nregistrationDate=" + registrationDate +
                ", \nisBanned=" + isBanned +
                ", \nip=" + ip +
                '}';
    }
}

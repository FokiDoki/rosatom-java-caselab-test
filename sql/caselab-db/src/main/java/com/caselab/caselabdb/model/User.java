package com.caselab.caselabdb.model;

import java.net.Inet4Address;
import java.time.LocalDate;

public class User {
    private Long id;
    private String name;
    private String password;
    private LocalDate registrationDate;

    private boolean isBanned;

    private Inet4Address ip;


    public User(Long id, String name, String password, LocalDate registrationDate, boolean isBanned, Inet4Address ip) {
        this.id = id;
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

    public Inet4Address getIp() {
        return ip;
    }

    public void setIp(Inet4Address ip) {
        this.ip = ip;
    }
}

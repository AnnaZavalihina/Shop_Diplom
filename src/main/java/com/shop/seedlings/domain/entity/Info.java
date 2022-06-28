package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "info")
public class Info {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "requisites")
    private String requisites;
    @Column(name = "email")
    private String email;
    @Column(name = "mailing_address")
    private String mailingAddress;
    @Column(name = "registration_number")
    private int registrationNumber;

    public Info(String name, String requisites, String email, String mailingAddress, int registrationNumber) {
        this.name = name;
        this.requisites = requisites;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.registrationNumber = registrationNumber;
    }

    public Info() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info shop = (Info) o;
        return id == shop.id && registrationNumber == shop.registrationNumber && Objects.equals(name, shop.name) && Objects.equals(requisites, shop.requisites) && Objects.equals(email, shop.email) && Objects.equals(mailingAddress, shop.mailingAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, requisites, email, mailingAddress, registrationNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
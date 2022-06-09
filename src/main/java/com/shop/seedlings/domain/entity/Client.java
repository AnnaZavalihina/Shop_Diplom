package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "tel_number")
    private int telNumber;

    @Column(name = "index")
    private int index;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private int building;
    @Column(name = "housing")
    private String housing;
    @Column(name = "apartment")
    private int apartment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && telNumber == client.telNumber && index == client.index && building == client.building && apartment == client.apartment && Objects.equals(name, client.name) && Objects.equals(email, client.email) && Objects.equals(city, client.city) && Objects.equals(street, client.street) && Objects.equals(housing, client.housing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, telNumber, index, city, street, building, housing, apartment);
    }

    public Client(String name, String email, int telNumber, int index, String city, String street, int building, String housing, int apartment) {
        this.name = name;
        this.email = email;
        this.telNumber = telNumber;
        this.index = index;
        this.city = city;
        this.street = street;
        this.building = building;
        this.housing = housing;
        this.apartment = apartment;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
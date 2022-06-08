package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
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

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && index == address.index && building == address.building && apartment == address.apartment && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(housing, address.housing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, index, city, street, building, housing, apartment);
    }

    public Address(int index, String city, String street, int building, String housing, int apartment) {
        this.index = index;
        this.city = city;
        this.street = street;
        this.building = building;
        this.housing = housing;
        this.apartment = apartment;
    }
}

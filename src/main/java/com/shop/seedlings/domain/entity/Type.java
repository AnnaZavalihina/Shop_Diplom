package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "details")
    private String details;

    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL)
    private List<Subtype> subtypes;

    public Type() {
    }

    public Type(String name, String details, List<Subtype> subtypes) {
        this.name = name;
        this.details = details;
        this.subtypes = subtypes;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Subtype> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<Subtype> subtypes) {
        this.subtypes = subtypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id == type.id && Objects.equals(name, type.name) && Objects.equals(details, type.details) && Objects.equals(subtypes, type.subtypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, details, subtypes);
    }
}

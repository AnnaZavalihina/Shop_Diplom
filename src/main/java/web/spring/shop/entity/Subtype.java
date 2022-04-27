package web.spring.shop.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subtypes")
public class Subtype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String details;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtype")
    private List<Item> items;

    public Subtype() {
    }

    public Subtype(String name, String details, Type type, List<Item> items) {
        this.name = name;
        this.details = details;
        this.type = type;
        this.items = items;
    }

    public Subtype(int id, String name, String details, Type type, List<Item> items) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.type = type;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subtype subtype = (Subtype) o;
        return id == subtype.id && Objects.equals(name, subtype.name) && Objects.equals(details, subtype.details) && Objects.equals(type, subtype.type) && Objects.equals(items, subtype.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, details, type, items);
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
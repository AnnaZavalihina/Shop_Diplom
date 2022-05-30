package web.spring.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subtypes")
public class Subtype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "details")
    private String details;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private Type type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subtype")
    private List<Item> items;

}
package web.spring.shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "details")
    private String details;

    @OneToMany(mappedBy = "type",cascade = CascadeType.ALL)
    private List<Subtype> subtypes;

}

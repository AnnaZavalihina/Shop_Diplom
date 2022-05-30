package web.spring.shop.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "image")
    private String image;
    @Column(name = "details")
    private String details;
    @Column(name = "status")
    private String status;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "discount")
    private int discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subtype_id")
    private Subtype subtype;

}

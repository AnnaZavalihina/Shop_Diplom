package web.spring.shop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date_creation")
    private Date date;
    @Column(name = "price")
    private double price;
}
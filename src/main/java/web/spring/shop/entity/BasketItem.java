package web.spring.shop.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "basket_items")
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "quantity_buy")
    private Date quantity;
    @Column(name = "price")
    private double price;
}
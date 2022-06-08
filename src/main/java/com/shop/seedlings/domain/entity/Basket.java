package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "basket")
    private List<BasketItem> basketItems;

    public Basket() {
    }

    public Basket(Date date, double price, List<BasketItem> basketItems) {
        this.date = date;
        this.price = price;
        this.basketItems = basketItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return id == basket.id && Double.compare(basket.price, price) == 0 && Objects.equals(date, basket.date) && Objects.equals(basketItems, basket.basketItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, price, basketItems);
    }
}
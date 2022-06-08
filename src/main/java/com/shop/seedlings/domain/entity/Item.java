package com.shop.seedlings.domain.entity;

import javax.persistence.*;
import java.util.List;
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
    private int status;
    @Column(name = "discount")
    private boolean discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subtype_id")
    private Subtype subtype;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<BasketItem> basketItems;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private List<OrderItem> orderItems;

    public Item() {
    }

    public Item(String name, double unitPrice, String image, String details, int status, boolean discount, Subtype subtype, List<BasketItem> basketItems, List<OrderItem> orderItems) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.image = image;
        this.details = details;
        this.status = status;
        this.discount = discount;
        this.subtype = subtype;
        this.basketItems = basketItems;
        this.orderItems = orderItems;
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Double.compare(item.unitPrice, unitPrice) == 0 && status == item.status && discount == item.discount && Objects.equals(name, item.name) && Objects.equals(image, item.image) && Objects.equals(details, item.details) && Objects.equals(subtype, item.subtype) && Objects.equals(basketItems, item.basketItems) && Objects.equals(orderItems, item.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitPrice, image, details, status, discount, subtype, basketItems, orderItems);
    }
}

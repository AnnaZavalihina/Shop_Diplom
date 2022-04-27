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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User seller;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subtype_id")
    private Subtype subtype;

    public Item() {
    }

    public Item(int id, String name, double unitPrice, String image, String details, String existence) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.image = image;
        this.details = details;
        this.status = status;
    }

    public Item(String name, double unitPrice, String image, String details, String status) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.image = image;
        this.details = details;
        this.status = status;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && Double.compare(item.unitPrice, unitPrice) == 0 && Objects.equals(name, item.name) && Objects.equals(image, item.image) && Objects.equals(details, item.details) && Objects.equals(status, item.status) && Objects.equals(seller, item.seller) && Objects.equals(subtype, item.subtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, unitPrice, image, details, status, seller, subtype);
    }

    public Subtype getSubtype() {
        return subtype;
    }

    public void setSubtype(Subtype subtype) {
        this.subtype = subtype;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

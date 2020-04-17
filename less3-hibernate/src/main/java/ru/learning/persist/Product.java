package ru.learning.persist;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String cost;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL
    )
    private List<Buy> productbuy;

    public Product() {
    }

    public Product(String title, String cost, List<Buy> productbuy) {
        this.title = title;
        this.cost = cost;
        this.productbuy = productbuy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }

    public List<Buy> getProductbuy() {
        return productbuy;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setProductbuy(List<Buy> productbuy) {
        this.productbuy = productbuy;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}

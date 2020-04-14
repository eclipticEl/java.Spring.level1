package ru.learning.persist;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate buyDate;

    @Column
    private double productCost;

    @ManyToOne
    private Person client;

    @ManyToOne
    private Product product;

    public Buy() {
    }

    public Buy(Person client, Product product, double productCost) {
        this.client = client;
        this.product = product;
        this.buyDate = LocalDate.now();
        this.productCost = productCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person person) {
        this.client = person;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "buyDate=" + buyDate +
                ", productCost=" + productCost +
                ", client=" + client +
                ", product=" + product +
                '}';
    }
}

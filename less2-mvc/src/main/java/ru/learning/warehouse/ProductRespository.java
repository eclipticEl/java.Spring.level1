package ru.learning.warehouse;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRespository {

    private final AtomicInteger identity = new AtomicInteger(0);

    private final List<Product> products =  new ArrayList<>();

    public ProductRespository() {
        insert(new Product("Appl", 75));
        insert(new Product("Orange",130));
    }

    public void insert(Product product){
        product.setId(identity.incrementAndGet());
        products.add(product);
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }

    public Product getProductByID(int id){
        for (Product prod:products) {
            if (prod.getId() == id){
                return  prod;
            }
        }

        return null;
    }

    public  Product getProductByName(String title){
        for (Product prod:products) {
            if (prod.getTitle() == title) {
                return  prod;
            }
        }
        return null;
    }

}

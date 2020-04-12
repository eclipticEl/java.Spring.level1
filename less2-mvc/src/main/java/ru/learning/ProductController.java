package ru.learning;

import ru.learning.warehouse.Product;
import ru.learning.warehouse.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRespository productRespository;

    @Autowired
    public ProductController(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @GetMapping
    public String allProducts(Model model){
        model.addAttribute("products", productRespository.getAllProducts());
        return "products";
    }

    @GetMapping("/form")
    public String formProduct(Model model){
        model.addAttribute("product", new Product());

        return "product_form";
    }

    @PostMapping("/form")
    public String createProduct(Product product){
        productRespository.insert(product);
        return  "redirect:/product";
    }

}


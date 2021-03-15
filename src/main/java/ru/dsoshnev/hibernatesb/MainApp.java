package ru.dsoshnev.hibernatesb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dsoshnev.hibernatesb.model.Customer;
import ru.dsoshnev.hibernatesb.model.Product;
import ru.dsoshnev.hibernatesb.service.ProductService;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainApp.class, args);
        ProductService productService = context.getBean(ProductService.class);

        Product product = productService.findById(1L).get();
        System.out.println(product);
        for (Customer customer: product.getCustomers()) {
            System.out.println(customer);
            System.out.println(customer.getProducts());
        }
        // Test for Null
        System.out.println(productService.findById(100L));
    }
}


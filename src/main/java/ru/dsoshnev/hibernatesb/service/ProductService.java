package ru.dsoshnev.hibernatesb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dsoshnev.hibernatesb.model.Customer;
import ru.dsoshnev.hibernatesb.model.Product;
import ru.dsoshnev.hibernatesb.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    public Iterable<Customer> findCustomersById(Long id) {
        return productRepository.findCustomersById(id);
    }
}

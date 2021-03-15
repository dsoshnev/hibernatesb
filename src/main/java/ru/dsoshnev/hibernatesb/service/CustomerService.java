package ru.dsoshnev.hibernatesb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dsoshnev.hibernatesb.model.Customer;
import ru.dsoshnev.hibernatesb.model.Product;
import ru.dsoshnev.hibernatesb.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public void setProductRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }
    public Iterable<Product> findProductsById(Long id) {
        return customerRepository.findProductsById(id);
    }
}

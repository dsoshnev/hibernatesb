package ru.dsoshnev.hibernatesb.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.dsoshnev.hibernatesb.model.Customer;
import ru.dsoshnev.hibernatesb.model.Product;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public Optional<Customer> findById(Long id) {
        Optional<Customer> customer;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            customer = Optional.ofNullable(session.get(Customer.class, id));
            session.getTransaction().commit();
        }
        return customer;
    }

    public Iterable<Product> findProductsById(Long id) {
        List<Product> list;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer= session.get(Customer.class, id);
            list = customer.getProducts();
            session.getTransaction().commit();
        }
        return list;
    }
}

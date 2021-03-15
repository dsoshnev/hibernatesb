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
public class ProductRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductRepository(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    public Optional<Product> findById(Long id) {
        Optional<Product> product;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            product = Optional.ofNullable(session.get(Product.class, id));
            session.getTransaction().commit();
        }
        return product;
    }

    public Iterable<Customer> findCustomersById(Long id) {
        List<Customer> list;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            list = product.getCustomers();
            session.getTransaction().commit();
        }
        return list;
    }

}

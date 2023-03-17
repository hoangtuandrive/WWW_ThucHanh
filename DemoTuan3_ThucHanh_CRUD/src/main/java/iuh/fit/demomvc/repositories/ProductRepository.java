package iuh.fit.demomvc.repositories;

import iuh.fit.demomvc.entities.Manufacturer;
import iuh.fit.demomvc.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductRepository {
    EntityManager entityManager;
    public ProductRepository() {
        entityManager = Persistence.createEntityManagerFactory("ProductManagement")
                .createEntityManager();
    }

    public List<Product> findAll() {
        String sql = "from Product" ;
        List<Product> lst = entityManager.createQuery(sql).getResultList();
        return lst;
    }

    public Product save(Product product) {
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return product;
    }

    public Product findProductById(String id){
        return entityManager.find(Product.class,Long.parseLong(id));
    }
    public boolean delete(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product =findProductById(id);
            entityManager.remove(product);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(String id, Product new_product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product =findProductById(id);
            product.setProductName(new_product.getProductName());
            product.setDescription(new_product.getDescription());
            product.setManuf(new_product.getManuf());

            entityManager.merge(product);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}

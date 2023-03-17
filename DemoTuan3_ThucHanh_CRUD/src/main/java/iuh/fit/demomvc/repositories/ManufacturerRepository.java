package iuh.fit.demomvc.repositories;



import iuh.fit.demomvc.entities.Manufacturer;
import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class ManufacturerRepository {

    EntityManager entityManager;
    public ManufacturerRepository() {
        entityManager = Persistence.createEntityManagerFactory("ProductManagement")
                .createEntityManager();
    }

    public List<Manufacturer> findAll() {
        String sql = "from Manufacturer" ;
        List<Manufacturer> lst = entityManager.createQuery(sql).getResultList();
        return lst;
    }

    public Manufacturer save(Manufacturer manufacturer) {
        EntityTransaction transaction =entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(manufacturer);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return null;
        }
        return manufacturer;
    }

    public Manufacturer findManufacturerById(String id){
        return entityManager.find(Manufacturer.class,Long.parseLong(id));
    }
    public boolean delete(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Manufacturer manufacturer =findManufacturerById(id);
            entityManager.remove(manufacturer);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(String id, Manufacturer new_manufacturer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Manufacturer manufacturer =findManufacturerById(id);
            manufacturer.setManContactName(new_manufacturer.getManContactName());
            manufacturer.setManContactEmail(new_manufacturer.getManContactEmail());
            manufacturer.setManName(new_manufacturer.getManName());
            manufacturer.setManContactPhone(new_manufacturer.getManContactPhone());
            manufacturer.setManWebsite(new_manufacturer.getManWebsite());
            entityManager.merge(manufacturer);
            transaction.commit();
        } catch(Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}

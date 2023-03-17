package iuh.fit.demomvc.services;

import iuh.fit.demomvc.entities.Manufacturer;
import iuh.fit.demomvc.entities.Product;
import iuh.fit.demomvc.repositories.ManufacturerRepository;
import iuh.fit.demomvc.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findProductById(id);
    }

    public Boolean delete(String id) { return productRepository.delete(id); }

    public  Boolean update(String id,Product product) {return  productRepository.update(id,product);}
}

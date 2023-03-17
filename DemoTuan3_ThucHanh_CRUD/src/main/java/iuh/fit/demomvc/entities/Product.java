package iuh.fit.demomvc.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tblProduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 40, unique = true, nullable = false)
    private String productName;

    @Column(length = 40, unique = true, nullable = false)
    private String description;


    @ManyToOne
    @JoinColumn(name="manId")
    private Manufacturer manuf;

    public Product() {
    }

    public Product(Long productId, String productName, String description, Manufacturer manuf) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manuf = manuf;
    }

    public Product(String productName, String description, Manufacturer manuf) {
        this.productName = productName;
        this.description = description;
        this.manuf = manuf;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManuf() {
        return manuf;
    }

    public void setManuf(Manufacturer manuf) {
        this.manuf = manuf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", manuf=" + manuf +
                '}';
    }
}

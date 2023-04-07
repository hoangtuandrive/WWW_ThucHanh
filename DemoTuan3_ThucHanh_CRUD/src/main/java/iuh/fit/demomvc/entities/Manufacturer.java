package iuh.fit.demomvc.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tblManufactory")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manId;

    @Column(length = 100, nullable = false)
    private String manName;

    @Column(length = 100, nullable = false)
    private String manContactName;

    @Column(length = 100, unique = true, nullable = false)
    private String manContactEmail;

    @Column(length = 100, unique = true, nullable = false)
    private String manContactPhone;

    @Column(length = 100, unique = true, nullable = false)
    private String manWebsite;

    @OneToMany(mappedBy = "manuf")
    private List<Product> lsProduct;

    public Manufacturer() {
    }

    public Manufacturer(String manName, String manContactName, String manContactEmail, String manContactPhone, String manWebsite) {
        this.manName = manName;
        this.manContactName = manContactName;
        this.manContactEmail = manContactEmail;
        this.manContactPhone = manContactPhone;
        this.manWebsite = manWebsite;
    }


    public Long getId() {
        return manId;
    }


    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManContactName() {
        return manContactName;
    }

    public void setManContactName(String manContactName) {
        this.manContactName = manContactName;
    }

    public String getManContactEmail() {
        return manContactEmail;
    }

    public void setManContactEmail(String manContactEmail) {
        this.manContactEmail = manContactEmail;
    }

    public String getManContactPhone() {
        return manContactPhone;
    }

    public void setManContactPhone(String manContactPhone) {
        this.manContactPhone = manContactPhone;
    }

    public String getManWebsite() {
        return manWebsite;
    }

    public void setManWebsite(String manWebsite) {
        this.manWebsite = manWebsite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return manId.equals(that.manId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manId);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + manId +
                ", manName='" + manName + '\'' +
                ", manContactName='" + manContactName + '\'' +
                ", manContactEmail='" + manContactEmail + '\'' +
                ", manContactPhone='" + manContactPhone + '\'' +
                ", manWebsite='" + manWebsite + '\'' +
                '}';
    }
}

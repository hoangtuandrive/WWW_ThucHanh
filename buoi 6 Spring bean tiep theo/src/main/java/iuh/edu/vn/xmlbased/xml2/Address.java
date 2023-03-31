package iuh.edu.vn.xmlbased.xml2;

public class Address {
    private String number;
    private String street;
    private String ward;
    private String district;
    private String city;

    public Address() {
    }

    public Address(String number, String street, String ward, String district, String city) {
        this.number = number;
        this.street = street;
        this.ward = ward;
        this.district = district;
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

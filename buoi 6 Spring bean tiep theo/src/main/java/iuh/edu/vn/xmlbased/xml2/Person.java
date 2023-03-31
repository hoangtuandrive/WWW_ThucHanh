package iuh.edu.vn.xmlbased.xml2;

import java.util.List;

public class Person {
    private String id;
    private String fullname;
    private List<Address>addresses;
    private List<String> emails;

    public Person() {

    }

    public Person(String id, String fullname, List<Address> addresses, List<String> emails) {
        this.id = id;
        this.fullname = fullname;
        this.addresses = addresses;
        this.emails = emails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", addresses=" + addresses +
                ", emails=" + emails +
                '}';
    }
}

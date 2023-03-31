package iuh.edu.vn.xmlbased.autowire;

public class Faculty {
    private String f_name;

    public Faculty() {
    }

    public Faculty(String f_name) {
        this.f_name = f_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "f_name='" + f_name + '\'' +
                '}';
    }
}

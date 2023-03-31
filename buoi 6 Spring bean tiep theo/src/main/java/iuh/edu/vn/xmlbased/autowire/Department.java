package iuh.edu.vn.xmlbased.autowire;

public class Department {
    private String dept_name;
    private Faculty faculty;

    public Department() {

    }

    public Department(String dept_name, Faculty faculty) {
        this.dept_name = dept_name;
        this.faculty = faculty;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Department{" +
                "dept_name='" + dept_name + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}

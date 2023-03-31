package iuh.edu.vn.xmlbased.xml;

public class Student {
    private long id;

    private String name;

    private Course course;

    public Student() {
    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(long id, String name, Course course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}

package vn.iuh.fit.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ShapeService shapeService = annotationConfigApplicationContext.getBean(ShapeService.class);

        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");
        Circle circle = classPathXmlApplicationContext.getBean("circle", Circle.class);
        shapeService.setShape(circle);
        System.out.println("Chu vi hinh tron: "+shapeService.tinhChuVi());

        Triangle triangle = classPathXmlApplicationContext.getBean("triangle", Triangle.class);
        shapeService.setShape(triangle);
        System.out.println("Chu vi hinh tam giac: "+shapeService.tinhChuVi());
        if(triangle.isTamGiacVuong()) System.out.println("Day la tam giac vuong");

        Rectangle rectangle = classPathXmlApplicationContext.getBean("rectangle", Rectangle.class);
        shapeService.setShape(rectangle);
        System.out.println("Chu vi hinh chu nhat: " + shapeService.tinhChuVi());

        SquareTrapezoid squareTrapezoid = new SquareTrapezoid(rectangle, triangle);
        shapeService.setShape(squareTrapezoid);
        System.out.println("Chu vi hinh thang vuong: " + shapeService.tinhChuVi());
    }
}

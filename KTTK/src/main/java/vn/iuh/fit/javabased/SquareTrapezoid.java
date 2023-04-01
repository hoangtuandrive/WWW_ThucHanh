package vn.iuh.fit.javabased;

import org.springframework.stereotype.Component;

@Component
public class SquareTrapezoid implements Shape{
    private Rectangle rectangle;
    private Triangle triangle;

    public SquareTrapezoid() {
    }

    public SquareTrapezoid(Rectangle rectangle, Triangle triangle) throws Exception {
        if(triangle.isTamGiacVuong()){
            this.rectangle = rectangle;
            this.triangle = triangle;
        }
        else{
            throw new RuntimeException("Khong phai hinh thang vuong");
        }
    }

    @Override
    public String toString() {
        return "SquareTrapezoid{" +
                "rectangle=" + rectangle +
                ", triangle=" + triangle +
                '}';
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    @Override
    public double dienTich() {
        return triangle.dienTich()+rectangle.dienTich();
    }

    @Override
    public double chuVi() {
        return triangle.chuVi()+rectangle.chuVi();
    }
}

package vn.iuh.fit.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ShapeService {

    private Shape shape;

    public ShapeService(Shape shape) {
        this.shape = shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double tinhDienTich(){
        return shape.dienTich();
    }

    public double tinhChuVi(){
        return shape.chuVi();
    }
}

package vn.iuh.fit.javabased;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape{
    private double banKinh;

    public double getBanKinh() {
        return banKinh;
    }

    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public Circle() {
    }

    public Circle(double banKinh) {
        this.banKinh = banKinh;
    }

    @Override
    public String toString() {
        return "Square{" +
                "banKinh=" + banKinh +
                '}';
    }

    @Override
    public double dienTich() {
        return Math.pow(banKinh,2)*Math.PI;
    }

    @Override
    public double chuVi() {
        return 2*banKinh*Math.PI;
    }
}

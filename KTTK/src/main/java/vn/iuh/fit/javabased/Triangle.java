package vn.iuh.fit.javabased;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Triangle implements Shape{
    private double a,b,c;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public double dienTich() {
        return Math.sqrt(chuVi()*(chuVi()-a)*(chuVi()-b)*(chuVi()-c));
    }

    @Override
    public double chuVi() {
        return a+b+c;
    }

    public boolean isTamGiacVuong(){
        if (Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2))
            return true;
        else if(Math.pow(c,2) + Math.pow(b,2) == Math.pow(a,2))
            return true;
        else if(Math.pow(a,2) + Math.pow(c,2) == Math.pow(b,2))
            return true;
        return false;
    }
}

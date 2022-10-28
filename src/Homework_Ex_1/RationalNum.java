package Homework_Ex_1;

public class RationalNum {
    public double real; // реальная часть


    public RationalNum(double real) { // конструктор с параметрами
        this.real = real;
    }

    public RationalNum() {
//        this(0);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
}
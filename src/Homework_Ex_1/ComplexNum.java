package Homework_Ex_1;

public class ComplexNum extends RationalNum {

    public double image; // мнимая часть

    public ComplexNum(double real, double image) { // конструктор с параметрами
        super.real = real;
        this.image = image;
    }

    public ComplexNum() {
//        this(0,0);
    }

    public double getImage() {
        return image;
    }

    public void setImage(double image) {
        this.image = image;
    }
}

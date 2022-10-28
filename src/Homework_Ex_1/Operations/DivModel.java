package Homework_Ex_1.Operations;

import Homework_Ex_1.ComplexNum;

public class DivModel extends CalcModel {
    @Override
    public ComplexNum result() {
        double newReal = (super.b.getReal()*super.a.getReal() +
                super.b.getImage()*super.a.getImage())/
                (super.b.getReal()*super.b.getReal()+super.b.getImage()*super.b.getImage());
        double newImage = (super.b.getReal()*super.a.getImage() -
                super.a.getReal()*super.b.getImage())/
                (super.b.getReal()*super.b.getReal()+super.b.getImage()*super.b.getImage());
        ComplexNum result = new ComplexNum(newReal, newImage);
        return result;
    }

    @Override
    public void setA(ComplexNum c) {
        super.a.real = c.getReal();
        super.a.image = c.getImage();
    }

    @Override
    public void setB(ComplexNum c) {
        super.b.real = c.getReal();
        super.b.image = c.getImage();
    }
}

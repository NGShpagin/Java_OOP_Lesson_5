package Homework_Ex_1;

import Homework_Ex_1.Operations.DivModel;
import Homework_Ex_1.Operations.Model;
import Homework_Ex_1.Operations.MultiModel;
import Homework_Ex_1.Operations.SumModel;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Presenter {
    View v;
    Model m;
    Logger logger;
    FileHandler fh;
    SimpleFormatter sFormat;

    public Presenter(View v) throws Exception {
        this.v = v;
        logger = Logger.getLogger("CalcLog");
        fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
    }

    public void getOperand() {
        System.out.println(v.viewMenu());
        switch (v.getOperand()) {
            case "+":
                this.m = new SumModel();
                break;
            case "-":
                this.m = new SumModel();
                break;
            case "/":
                this.m = new DivModel();
                break;
            case "*":
                this.m = new MultiModel();
                break;
        }
    }

    public void clickButton() {
        ComplexNum a = v.getValue();
        ComplexNum b = v.getValue();
        m.setA(a);
        m.setB(b);
        ComplexNum result = m.result();
        System.out.println(v.print("Результат ",result));
        this.logger.log(Level.INFO, v.print("", result));
    }
}

package Ex_1_Calc;

public class App {
    public static void main(String[] args) {
        var m = new SumModel();
        var v = new View();
        Presenter p = new Presenter(m, v);
//        Presenter p = new Presenter(new SumModel(), new View());
        p.buttonClaick();
    }
}

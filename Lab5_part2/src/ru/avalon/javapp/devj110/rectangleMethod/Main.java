package ru.avalon.javapp.devj110.rectangleMethod;


public class Main {


    public static void main(String[] args) {
    
        Function f1 = new F1();    // вложенный класс
        System.out.println(rectangleMethod(f1, 2, 5));
        
        Function f2 = new Function() { // анонимный класс
        public double f(double x) {
        return x*x+x;
        }       
        };
        System.out.println(rectangleMethod(f2, 3, 4));
        
        Function f3 = Function::staticMeth;      // статический метод
        System.out.println(rectangleMethod(f3, 0.01, 2));
        
        F4 func4 = new F4();    // ссылка на метод экземпляра
        Function f4 = func4::sqr;
        System.out.println(rectangleMethod(f4, 1, 3));
        
        Function f5 = x -> x*Math.sin(x); // лямбда выражение
        System.out.println(rectangleMethod(f5, 0, 1));
    
    }
               
       
    
    private static final int PARTS = 100;
        
    
    public static double rectangleMethod (Function function, double left, double right){
        double s = 0;
        double step = (right - left) / PARTS;
        double x = left;
        double xn = left + step;
        for (int i = 0; i < PARTS; i++ ){
             s = s + step * function.f((x+xn)/2);
             x = xn;
             xn = xn + step;
        }
        return s;
    }
    
    private static class F1 implements Function { // вложенный класс
        @Override
        public double f(double x) {
            return Math.log(x);
        }
    }
}

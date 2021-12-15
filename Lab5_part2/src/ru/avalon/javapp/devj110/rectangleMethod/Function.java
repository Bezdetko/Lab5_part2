package ru.avalon.javapp.devj110.rectangleMethod;

public interface Function {
    double f(double x);
        
    public static double staticMeth(double x) {
        return Math.exp(-x);
    }
    
}

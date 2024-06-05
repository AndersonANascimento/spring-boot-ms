package br.com.prodam.math;

public class SimpleMath {
    public Double sum(Double num1, Double num2) {
        return num1 + num2;
    }

    public Double sub(Double num1, Double num2) {
        return num1 - num2;
    }

    public Double mult(Double num1, Double num2) {
        return num1 * num2;
    }

    public Double div(Double num1, Double num2) {
        return num1 / num2;
    }

    public Double avg(Double num1, Double num2) {
        return (num1 + num2) / 2d;
    }

    public Double sqrt(Double num1) {
        return Math.sqrt(num1);
    }
}

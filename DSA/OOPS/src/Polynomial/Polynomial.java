package Polynomial;

import DynamicArray.DynamicArray;

public class Polynomial {
    DynamicArray coefficients;

    public Polynomial() {
        coefficients = new DynamicArray();
    }

    public void setCoefficients(int deg, int coeff) {
        coefficients.setDeg(deg, coeff);
    }

    public int getCoefficients(int deg) {
        return coefficients.get(deg);
    }

    public void print() {
        for(int i = 0; i < coefficients.length(); i++) {
            if(getCoefficients(i) != 0) {
                System.out.print(getCoefficients(i) + "x^" + i + " + ");
            }
        }
//        System.out.print(coefficients.get(coefficients.size()-1) + "x^" + coefficients.size());
    }
}

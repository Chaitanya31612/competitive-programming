package Polynomial;

public class PolynomialUse {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial();
        p1.setCoefficients(0, 3);
        p1.setCoefficients(2,2);
        p1.setCoefficients(5, 10);
//        System.out.println(p1.coefficients.length());
//        System.out.println(p1.coefficients.get(0));
//        System.out.println(p1.getCoefficients(1));
//        System.out.println(p1.getCoefficients(2));
//        System.out.println(p1.getCoefficients(5));

//        System.out.println(p1.coefficients.size());
        p1.print();
    }
}

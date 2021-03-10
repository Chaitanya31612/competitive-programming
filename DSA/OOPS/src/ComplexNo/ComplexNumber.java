package ComplexNo;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public void print() {
        System.out.println(this.real + " + i" + this.imaginary);
    }

    public void add(ComplexNumber c2) {
        this.real += c2.getReal();
        this.imaginary += c2.getImaginary();
    }

    public void multiply(ComplexNumber c2) {
        this.real = this.real * c2.getReal() - this.imaginary * c2.getImaginary();
        this.imaginary = this.imaginary * c2.getReal() + this.real * c2.getImaginary();
    }

    public ComplexNumber conjugate() {
        ComplexNumber c2 = new ComplexNumber(this.real, (-1 * this.imaginary));
        return c2;
    }

    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber c3 = new ComplexNumber(c1.getReal() + c2.getReal(), c1.getImaginary() + c2.getImaginary());
        return c3;
    }
}

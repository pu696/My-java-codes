package cn.edu.pp2;

import java.math.BigInteger;

public class count {
    public static void main(String[] args) {
        Complex result = complexPower(new Complex(2, 3), 123456);
        System.out.println(result);
    }
    
    static class Complex {
        BigInteger real; 
        BigInteger imag; 
        
        Complex(int real, int imag) {
            this.real = BigInteger.valueOf(real);
            this.imag = BigInteger.valueOf(imag);
        }
        
        Complex(BigInteger real, BigInteger imag) {
            this.real = real;
            this.imag = imag;
        }
        
        Complex multiply(Complex other) {
            BigInteger newReal = this.real.multiply(other.real)
                                .subtract(this.imag.multiply(other.imag));
            BigInteger newImag = this.real.multiply(other.imag)
                                .add(this.imag.multiply(other.real));
            return new Complex(newReal, newImag);
        }
        
        @Override
        public String toString() {
            String realStr = real.toString();
            String imagStr;
            if (imag.compareTo(BigInteger.ZERO) >= 0) {
                imagStr = "+" + imag.toString() + "i";
            } else {
                imagStr = imag.toString() + "i";
            }
            return realStr + imagStr;
        }
    }
    
    static Complex complexPower(Complex base, int exponent) {
        Complex result = new Complex(1, 0); 
        
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = result.multiply(base);
            }
            base = base.multiply(base);
            exponent >>= 1;
        }
        
        return result;
    }
}
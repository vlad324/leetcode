package io.github.vlad324.n537;

/**
 * {@link "https://leetcode.com/problems/complex-number-multiplication/"}
 */
class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        final var a = ComplexNumber.parse(num1);
        final var b = ComplexNumber.parse(num2);

        return a.multiply(b).toString();
    }

    private static class ComplexNumber {
        private final int real;
        private final int imaginary;

        private ComplexNumber(int real, int imaginary) {
            this.real = real;
            this.imaginary = imaginary;
        }

        public static ComplexNumber parse(String num) {
            final int i = num.indexOf("+");
            return new ComplexNumber(
                Integer.parseInt(num, 0, i, 10),
                Integer.parseInt(num, i + 1, num.length() - 1, 10));
        }

        public ComplexNumber multiply(ComplexNumber other) {
            return new ComplexNumber(
                this.real * other.real - this.imaginary * other.imaginary,
                this.real * other.imaginary + this.imaginary * other.real);
        }

        @Override
        public String toString() {
            return String.format("%s+%si", real, imaginary);
        }
    }

    public String complexNumberMultiply2(String num1, String num2) {
        final int plus1 = num1.indexOf("+");
        final int r1 = Integer.parseInt(num1, 0, plus1, 10);
        final int i1 = Integer.parseInt(num1, plus1 + 1, num1.length() - 1, 10);

        final int plus2 = num2.indexOf("+");
        final int r2 = Integer.parseInt(num2, 0, plus2, 10);
        final int i2 = Integer.parseInt(num2, plus2 + 1, num2.length() - 1, 10);

        return (r1 * r2 - i1 * i2) + "+" + (r1 * i2 + i1 * r2) + "i";
    }
}

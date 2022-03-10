package com.endava.calculator.basic;

public class Basic implements BasicOperations {

    protected int decimals;

    public Basic() {
        this.decimals = 10;
    }

    public Basic(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public Long add(int... no) { // "..." numar variabil de argumente
        Long sum = Long.valueOf(0);
        for (int n : no) {
            sum += n;
        }
        return sum;

    }

    @Override
    public long add(long... no) {
        long sum = 0;
        for (long n : no) {
            sum += n;
        }
        return sum;
    }

    @Override
    public double add(double... no) {
        double sum = 0;
        for (double n : no) {
            sum += n;
        }
        return formatNumber(sum);
    }

    @Override
    public int substract(int... no) {
        int result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return result;
    }

    @Override
    public long substract(long... no) {
        long result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return result;
    }

    @Override
    public double substract(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result -= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public long multiply(int... no) {
        try {
            long result = no[0];
            for (int i = 1; i < no.length; i++) {
                result *= no[i];
            }
            return result;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("There is no given operand");
            return 0;
        }
    }

    @Override
    public long multiply(long... no) {
        long result = no[0];
        for (int i = 1; i < no.length; i++) {
            result *= no[i];
        }
        return result;
    }

    @Override
    public double multiply(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result *= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(int... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(long... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    @Override
    public double divide(double... no) {
        double result = no[0];
        for (int i = 1; i < no.length; i++) {
            result /= no[i];
        }
        return formatNumber(result);
    }

    protected double formatNumber(double n) {
        String s = String.format("%." + decimals + "f", n);
        return Double.parseDouble(s);
    }


}

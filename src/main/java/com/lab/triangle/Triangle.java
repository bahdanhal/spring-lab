package com.lab.triangle;

public class Triangle {

    private double min;
    private double mid;
    private double max;
    private static char impossible;
    private static char equilateral;
    private static char isosceles;
    private static char rectangular;
    public Triangle(double firstSide, double secondSide, double thirdSide) {
        min = firstSide;
        mid = secondSide;
        max = thirdSide;
        sort();
        setStatus();
    }
    private void setStatus(){
        if(impossible()){
            impossible = '+';
            equilateral = ' ';
            isosceles = ' ';
            rectangular = ' ';
            return;
        };
        impossible = '-';
        if(equilateral()){
            equilateral = '+';
        } else {
            equilateral = '-';
        }

        if(isosceles()){
            isosceles = '+';
        } else {
            isosceles = '-';
        }

        if(rectangular()){
            rectangular = '+';
        } else {
            rectangular = '-';
        }
    }
    private boolean impossible(){
        if((max >= min + mid) || (max <= 0) || (mid <= 0) || (min <= 0)){
            return true;
        }
        return false;
    }

    private boolean equilateral(){
        if(max == mid && min == mid){
            return true;
        }
        return false;
    }

    private boolean isosceles(){
        if((max == mid)||(mid==min)){
            return true;
        }
        return false;
    }

    private boolean rectangular() {
        if (max * max == min * min + mid * mid) {
            return true;
        }
        return false;
    }

    private void sort(){
        if(min > mid) {
            double tmp = min;
            min = mid;
            mid = tmp;
        }
        if(mid > max) {
            double tmp = mid;
            mid = max;
            max = tmp;
        }
        if(this.min > this.mid) {
            double tmp = min;
            min = mid;
            mid = tmp;
        }
    }

    public double getMin() {
        return min;
    }

    public double getMid() {
        return mid;
    }

    public double getMax() {
        return max;
    }

    public static char getEquilateral() {
        return equilateral;
    }

    public static char getImpossible() {
        return impossible;
    }

    public static char getIsosceles() {
        return isosceles;
    }

    public static char getRectangular() {
        return rectangular;
    }
}

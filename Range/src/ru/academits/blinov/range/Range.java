package ru.academits.blinov.range;

public class Range {
    public double from;
    public double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public double calculateLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return ((number >= this.from) && (number <= this.to));

    }

    public void checkCrossingRange (double from1, double to1, double from2, double to2) {
       if ((from1 >= from2 && from1 <= to2) && (to1 >= from2 && to1 <=to2)) {
           from = from1;
           to = to1;
       }
        if (from1 >= from2 && from1 <= to2) {
            from = from1;
            to = to1;
        }
    }

}

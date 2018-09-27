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

    public void checkRangeCrossing(double from, double to) {
        Range range = new Range(from, to);
        if ((from > this.to) || (to < this.from)) {
            range = null;
        } else {
            if (from >= this.from && from <= this.to) {
                if (to <= this.to) {
                    range.setFrom(from);
                    range.setTo(to);
                } else if (to > this.to) {
                    range.setFrom(from);
                    range.setTo(this.to);
                }
            } else {
                if (to <= this.to) {
                    range.setFrom(this.from);
                    range.setTo(to);
                } else if (to > this.to) {
                    range.setFrom(this.from);
                    range.setTo(this.to);
                }
            }
        }
        if (range == null) {
            System.out.println("Интервалы не пересекаются");
        } else {
            System.out.println("Интервал пересечения 2-х диапазонов: " + range.getFrom() + " - " + range.getTo());
        }
    }
}

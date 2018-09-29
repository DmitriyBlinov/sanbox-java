package ru.academits.blinov.range;

public class Range {
    private double from;
    private double to;

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
        return ((number >= from) && (number <= to));
    }

    public Range getCrossingOfRanges(Range range) {
        if ((range.from > to) || (range.to < from)) {
            return null;
        }
        if ((range.from >= from) && (range.from <= to)) {
            if (range.to <= to) {
                return new Range(range.from, range.to);
            } else {
                return new Range(range.from, to);
            }
        } else if (range.to <= to) {
            return new Range(from, range.to);
        } else {
            return this;
        }
    }

    public Range[] getUnionOfRanges(Range range) {
        if ((from > range.to) || (to < range.from)) {
            return new Range[]{this, range};
        } else {
            double minFrom = from < range.from ? from : range.from;
            double maxTo = to > range.to ? to : range.to;
            return new Range[]{new Range(minFrom, maxTo)};
        }
    }

    public Range[] getComplementOfRanges(Range range) {
        if ((from > range.to) || (to < range.from)) {
            return new Range[]{this};
        }
        if (from < range.from) {
            if ((to >= range.from) && (to <= range.to)) {
                return new Range[]{new Range(from, range.from)};
            } else {
                return new Range[]{new Range(from, range.from), new Range(range.to, to)};
            }
        } else {
            if (to > range.to) {
                return new Range[]{new Range(range.to, to)};
            } else {
                return null;
            }
        }
    }
}
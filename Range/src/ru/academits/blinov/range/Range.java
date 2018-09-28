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
        return Math.abs(to - from);
    }

    public boolean isInside(double number) {
        return ((number >= this.from) && (number <= this.to));

    }

    public void getCrossingOfRanges(double from, double to) {
        Range range = new Range(this.from, this.to);
        if ((from > this.to) || (to < this.from)) {
            range = null;
        } else {
            if ((from >= this.from) && (from <= this.to)) {
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

    public void getUnionOfRanges(double from, double to) {
        Range[] range = new Range[2];
        range[0] = new Range(this.from, this.to);
        range[1] = new Range(from, to);

        if ((this.from > to) || (this.to < from)) {
            range[0] = new Range(this.from, this.to);
            range[1] = new Range(from, to);
            System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
            System.out.println(", " + range[1].getFrom() + " - " + range[1].getTo());
        } else {
            if ((this.from < from)) {
                if (this.to > to) {
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                } else {
                    range[0] = new Range(this.from, to);
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                }
            } else if (this.from >= from) {
                if (this.to > to) {
                    range[0] = new Range(from, this.to);
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                } else {
                    range[0] = new Range(from, to);
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                }
            }
        }
    }

    public void getComplementOfRanges(double from, double to) {
        Range[] range = new Range[2];
        range[0] = new Range(this.from, this.to);
        range[1] = new Range(from, to);

        double epsilon = 1.0e-10;
        if ((this.from > to) || (this.to < from)) {
            range[0] = new Range(this.from, this.to);
            System.out.println("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
        } else {
            if (this.from < from) {
                if ((this.to >= from) && (this.to <= to)) {
                    range[0].setFrom(this.from);
                    range[0].setTo(from - epsilon);
                    System.out.println("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                } else {
                    range[0] = new Range(this.from, from - epsilon);
                    range[1] = new Range(to - epsilon, this.to);
                    System.out.print("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                    System.out.println(", " + range[1].getFrom() + " - " + range[1].getTo());
                }
            } else if ((this.from >= from) && (this.from <= to)) {
                if ((this.to >= from) && (this.to <= to)) {
                    System.out.println("Результат разности данных интервалов: 1-ый интервал полностью входит во 2-ой");
                } else {
                    range[0].setFrom(to - epsilon);
                    range[0].setTo(this.to);
                    System.out.println("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                }
            }
        }
    }
}

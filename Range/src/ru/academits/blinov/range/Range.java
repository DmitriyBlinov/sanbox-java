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

    public void getCrossingOfRanges(double from, double to) {
        Range range = new Range(this.from, this.to);
        if ((Math.abs(from) > Math.abs(this.to)) || (Math.abs(to) < Math.abs(this.from))) {
            range = null;
        } else {
            if ((Math.abs(from) >= Math.abs(this.from)) && (Math.abs(from) <= Math.abs(this.to))) {
                if (Math.abs(to) <= Math.abs(this.to)) {
                    range.setFrom(from);
                    range.setTo(to);
                } else if (Math.abs(to) > Math.abs(this.to)) {
                    range.setFrom(from);
                    range.setTo(this.to);
                }
            } else {
                if (Math.abs(to) <= Math.abs(this.to)) {
                    range.setFrom(this.from);
                    range.setTo(to);
                } else if (Math.abs(to) > Math.abs(this.to)) {
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

        if ((Math.abs(this.from) > Math.abs(to)) || (Math.abs(this.to) < Math.abs(from))) {
            range[0] = new Range(this.from, this.to);
            range[1] = new Range(from, to);
            System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
            System.out.println(", " + range[1].getFrom() + " - " + range[1].getTo());
        } else {
            if ((Math.abs(this.from) < Math.abs(from))) {
                if (Math.abs(this.to) > Math.abs(to)) {
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                } else {
                    range[0] = new Range(this.from, to);
                    System.out.print("Результат объединения интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                }
            } else if (Math.abs(this.from) >= Math.abs(from)) {
                if (Math.abs(this.to) > Math.abs(to)) {
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
        if ((Math.abs(this.from) > Math.abs(to)) || (Math.abs(this.to) < Math.abs(from))) {
            range[0] = new Range(this.from, this.to);
            System.out.println("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
        } else {
            if (Math.abs(this.from) < Math.abs(from)) {
                if ((Math.abs(this.to) >= Math.abs(from)) && (Math.abs(this.to) <= Math.abs(to))) {
                    range[0].setFrom(this.from);
                    range[0].setTo(from - epsilon);
                    System.out.println("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                } else {
                    range[0] = new Range(this.from, from - epsilon);
                    range[1] = new Range(to - epsilon, this.to);
                    System.out.print("Результат разности данных интервалов: " + range[0].getFrom() + " - " + range[0].getTo());
                    System.out.println(", " + range[1].getFrom() + " - " + range[1].getTo());
                }
            } else if ((Math.abs(this.from) >= Math.abs(from)) && (Math.abs(this.from) <= Math.abs(to))) {
                if ((Math.abs(this.to) >= Math.abs(from)) && (Math.abs(this.to) <= Math.abs(to))) {
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

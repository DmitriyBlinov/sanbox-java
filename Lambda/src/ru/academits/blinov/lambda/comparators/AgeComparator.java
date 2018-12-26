package ru.academits.blinov.lambda.comparators;

import ru.academits.blinov.lambda.person.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
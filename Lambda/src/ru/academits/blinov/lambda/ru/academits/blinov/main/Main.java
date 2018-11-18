package ru.academits.blinov.lambda.ru.academits.blinov.main;

import ru.academits.blinov.lambda.Person;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", 21);
        Person jack = new Person("Jack", 32);
        Person phil = new Person("Phil", 44);
        Person chris = new Person("Chris", 12);
        Person daisy = new Person("Daisy", 15);
        List<Person> persons = Arrays.asList(john, jack, phil, chris, daisy);

        String allNamesString = persons.stream().map()
    }
}

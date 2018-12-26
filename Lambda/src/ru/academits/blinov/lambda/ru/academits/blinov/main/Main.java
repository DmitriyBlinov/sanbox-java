package ru.academits.blinov.lambda.ru.academits.blinov.main;

import ru.academits.blinov.lambda.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", 21);
        Person jack = new Person("Jack", 32);
        Person phil = new Person("Phil", 44);
        Person chris = new Person("Chris", 12);
        Person daisy = new Person("Daisy", 15);
        Person john2 = new Person("John", 21);
        List<Person> persons = Arrays.asList(john, jack, phil, chris, daisy, john2);

        Stream<Person> stream = persons.stream().distinct();
        List<Person> filteredPersons = stream.collect(Collectors.toList());
        String allFilteredNames = filteredPersons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Имена: " + allFilteredNames);

        Stream<Person> stream2 = persons.stream().filter(p -> p.getAge() < 18);
        double averageAge = stream2
                .mapToDouble(Person::getAge).average();
        List<Person> youngPersons = stream2.collect(Collectors.toList());
        System.out.println(youngPersons);

        //оставить объекты, которые начинаются на al
        //stream.filter(x -> x.getName().startsWith(“al”))
    }
}

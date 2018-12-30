package ru.academits.blinov.lambda;

import ru.academits.blinov.person.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        Person john = new Person("John", 21);
        Person jack = new Person("Jack", 32);
        Person phil = new Person("Phil", 44);
        Person chris = new Person("Chris", 12);
        Person daisy = new Person("Daisy", 15);
        Person john2 = new Person("John", 87);
        Person john3 = new Person("John", 21);
        List<Person> persons = Arrays.asList(john, jack, phil, chris, daisy, john2, john3);

        List<String> filteredPersons = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());
        String filteredNames = filteredPersons.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Имена: " + filteredNames);

        double averageYoungAge = persons.stream().filter(p -> p.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст несовершеннолетних: " + averageYoungAge);

        Map<String, Double> personsMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.averagingInt(Person::getAge)));
        System.out.println("Map: " + personsMap.toString());

        List<Person> personsFilteredByAge = persons.stream()
                .filter(p -> (p.getAge() >= 20) && (p.getAge() <= 45))
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .collect(Collectors.toList());
        personsFilteredByAge.forEach(System.out::println);
    }
}
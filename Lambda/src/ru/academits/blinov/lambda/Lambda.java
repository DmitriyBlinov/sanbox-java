package ru.academits.blinov.lambda;

import ru.academits.blinov.lambda.person.Person;
import ru.academits.blinov.lambda.comparators.AgeComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Stream<Person> stream = persons.stream().distinct();
        List<Person> filteredPersons = stream.collect(Collectors.toList());
        String allFilteredNames = filteredPersons.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Имена: " + allFilteredNames);

        Stream<Person> stream2 = persons.stream().filter(p -> p.getAge() < 18);
        double averageYoungAge = stream2
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст несовершеннолетних: " + averageYoungAge);

        Map<String, Double> personsMap = filteredPersons.stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.averagingInt(Person::getAge)));
        System.out.println("Map: " + personsMap.toString());

        List<Person> personsFilteredByAge = persons.stream()
                .filter(p -> (p.getAge() >= 20) && (p.getAge() <= 45))
                .sorted(new AgeComparator())
                .collect(Collectors.toList());
        Collections.reverse(personsFilteredByAge);
        personsFilteredByAge.forEach(System.out::println);
    }
}
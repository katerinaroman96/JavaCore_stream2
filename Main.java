package com.stream.population;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static long underage (Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
    }

    public static List<String> military (Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(Person::getSurname)
                .collect(Collectors.toList());
    }

    public static List<Person> workable (Collection<Person> persons) {
        return persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getSex() == Sex.WOMAN && (person.getAge() >= 18 && person.getAge() < 60))
                || (person.getSex() == Sex.MAN && (person.getAge() >= 18 && person.getAge() < 65)))
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Катя", "Артём", "Саша", "Паша", "Маша", "Дуняша", "Добби");
        List<String> surnames = Arrays.asList("Катёнова", "Артёмов", "Сашева", "Пашев", "Машева", "Дуняшева");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random(). nextInt(Education.values().length)])
            );
        }
        System.out.println("Количество несовершеннолетних людей - " + underage(persons));
        System.out.println("Фамилии призывников - " + military(persons));
        System.out.println("Работоспособное население с высшим образованием: \n" + workable(persons));
    }
}

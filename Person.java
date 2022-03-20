package com.stream.population;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    private Education education;

    public Person(String name, String surname, Integer age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this. age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return  "\nимя - " + name +
                ", фамилия - " + surname +
                ", возраст - " + age +
                ", пол - " + sex +
                ", образование - " + education;
    }
}

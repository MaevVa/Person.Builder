package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private String name;
    private String surname;
    private int age;
    private String city;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(),
                person.getSurname()) && Objects.equals(getCity(), person.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getCity());
    }

    @Override
    public String toString() {
        return "Person{" +
                "имя = '" + name + '\'' +
                ", фамилия = '" + surname + '\'' +
                ", возраст = " + age +
                ", город проживания = '" + city + '\'' +
                '}';
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }
    public boolean hasAddress() {
        return getCity() != null;
    }
    public void happyBirthday() {
        this.age = age + 1;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(getSurname())
                .setAddress(getCity());
        return child;
    }

}

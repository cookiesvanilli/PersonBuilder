package org.example;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    protected OptionalInt age;
    protected Optional<String> city;

    {
        age = OptionalInt.empty();
        city = Optional.empty();
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.city = Optional.ofNullable(city);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    //setter
    public void setAge(int age) {
        this.age = OptionalInt.of(age);
    }

    public void setAddress(String city) {
        this.city = Optional.ofNullable(city);
    }

    //getter
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return city.orElse("Unknown");
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return city.isPresent();
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAddress(getAddress())
                .setAge(1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + (age.isEmpty() ? "Unknown" : age.getAsInt()) +
                ", town=" + getAddress() +
                '}';
    }

}

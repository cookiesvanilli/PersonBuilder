package org.example;

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
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

    //setter
    public void setAge(int age) {
        this.age = age;
    }

    public String setAddress(String city) {
        this.city = city;
        return city;
    }

    //getter
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return city;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
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
                ", age=" + age +
                ", town=" + getAddress() +
                '}';
    }

}

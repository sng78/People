package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age; //опция
    protected String address; //опция

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (hasAge()) {
            return age;
        }
        System.out.println("Возраст человека неизвестен!");
        return 0;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age += 1;
        } else {
            System.out.println("Возраст человека неизвестен!");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .surname(getSurname())
                .address(getAddress());
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
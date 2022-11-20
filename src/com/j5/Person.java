package com.j5;

public class Person {
    String lastName;
    String firstName;
    String middleName;
    int age;
    Person(String lastName, String firstName, String middleName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
    }

    public String toString() {
        return lastName + " "
                + (firstName.length() > 0 ? firstName + " " : "")
                + (middleName.length() > 0 ? middleName + " " : "")
                + age;
    }

    static Person createPerson(String input, int age) {
        String[] fioArr = input.split(" ");
        String lastName = fioArr[0];
        String firstName = "";
        String middleName = "";
        if (fioArr.length == 3) {
            firstName = fioArr[1];
            middleName = fioArr[2];
        } else if (fioArr.length == 2) {
            firstName = fioArr[1];
        }
        return new Person(lastName, firstName, middleName, age);
    }
}

package com.demo.employee;

public class Validator {

    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("[A-Za-z ]+");
    }

    public boolean validateAge(int age) {
        return age >= 18 && age <= 60;
    }

    public void validate(Employee employee) {

        if (!validateName(employee.getName())) {
            throw new InvalidNameException("Invalid employee name");
        }

        if (!validateAge(employee.getAge())) {
            throw new InvalidAgeException("Invalid employee age");
        }
    }
}

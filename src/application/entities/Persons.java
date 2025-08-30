package application.entities;

import java.util.Objects;

public class Persons {
    String name;
    String email;
    Double salary;

    public Persons( String name, String email, Double salary) {
        this.email = email;
        this.name = name;
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return Objects.equals(name, persons.name) && Objects.equals(email, persons.email) && Objects.equals(salary, persons.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, salary);
    }
}

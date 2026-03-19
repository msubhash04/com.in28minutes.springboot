package com.in28minutes.media_application.Entity;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "Name='" + name + '\'' +
                '}';
    }
}

package com.example.kunfish.stream.terminal.model;

public class User {

    private final String name;
    private final int age;
    private Rating rating = new Rating();

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + '}';
    }
}

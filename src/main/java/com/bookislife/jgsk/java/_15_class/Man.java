package com.bookislife.jgsk.java._15_class;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class Man {

    private String name;
    private int age;
    private final String from = "USA";
    private String description = "none";

    public Man() {

    }

    public Man(String name, int age, String description) {
        this.age = age;
        this.description = description;
        this.name = name;
    }

    public Man(String name, int age) {
        this(name, age, null);
    }

    public Man(int age) {
        this(null, age);
    }

    public Man(String name) {
        this(name, 0);
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append("name='").append(name).append("'");
        sb.append(", age=").append(age).append("'");
        sb.append(", from='").append(from).append("'");
        sb.append(", description='").append(description).append("'");
        sb.append('}');
        return sb.toString();
    }
}

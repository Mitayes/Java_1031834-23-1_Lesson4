package org.example.entity;

import org.example.enumClasses.Sex;

import java.util.Objects;

public abstract class Character {
    private String name;
    private Sex sex;

    protected Character(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public abstract void sayHello();

    // Getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    // default functions override
    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}

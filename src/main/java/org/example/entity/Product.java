package org.example.entity;

import java.util.Objects;

public class Product {
    private String name;
    private Float prise;

    public Product(String name, Float prise) {
        this.name = name;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrise() {
        return prise;
    }

    public void setPrise(Float prise) {
        this.prise = prise;
    }

    // default functions override
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name +
                ", prise=" + prise +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getPrise(), product.getPrise());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrise());
    }
}

package com.thehecklers.coffeeservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Coffee {
    @Id
    private String id;
    private String name, code;

    public Coffee() {
    }

    public Coffee(String name) {
        this.name = name;
        setCode(name);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setCode(name);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String name) {
        this.code = name.toLowerCase().replace(" ", "-");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) &&
                Objects.equals(name, coffee.name) &&
                Objects.equals(code, coffee.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
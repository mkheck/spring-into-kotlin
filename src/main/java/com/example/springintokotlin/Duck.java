package com.example.springintokotlin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Duck {
    @Id
    private String id;
    private String type;
    private String code;

    public Duck() {
    }

    public Duck(String type) {
        this.type = type;
        this.code = type.toLowerCase().replace(" ", "-");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getcode() {
        return code;
    }

    private void setcode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Duck duck = (Duck) o;

        if (!id.equals(duck.id)) return false;
        if (!type.equals(duck.type)) return false;
        return code.equals(duck.code);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

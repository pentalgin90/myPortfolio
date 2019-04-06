package by.home.annotation.domain;

import by.home.annotation.customAnnotation.SearchFind;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class SomeObject {
    @SearchFind
    private String name;
    private String lastnamr;
    @SearchFind
    private Integer age;
    private Long id;
    private String personalNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnamr() {
        return lastnamr;
    }

    public void setLastnamr(String lastnamr) {
        this.lastnamr = lastnamr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public SomeObject(String name, String lastnamr, Integer age, Long id, String personalNumber) {
        this.name = name;
        this.lastnamr = lastnamr;
        this.age = age;
        this.id = id;
        this.personalNumber = personalNumber;
    }

    public SomeObject() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeObject that = (SomeObject) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(lastnamr, that.lastnamr) &&
                Objects.equals(age, that.age) &&
                Objects.equals(id, that.id) &&
                Objects.equals(personalNumber, that.personalNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastnamr, age, id, personalNumber);
    }

    @Override
    public String toString() {
        return "SomeObject{" +
                "name='" + name + '\'' +
                ", lastnamr='" + lastnamr + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", personalNumber='" + personalNumber + '\'' +
                '}';
    }
}

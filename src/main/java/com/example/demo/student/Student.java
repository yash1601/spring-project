package com.example.demo.student;
import java.beans.BeanProperty;
//import java.beans.Transient;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToMany;
import com.example.demo.subject.Subject;
import jdk.jfr.DataAmount;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name="tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(name = "Student_name", nullable=false)
    private String name;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private Set<Subject> subjects = new HashSet<Subject>();

    private LocalDate dob;
    private String email;
    private Integer age;

    public Student() {
    }

    public Student(long id, String name, LocalDate dob, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    public Student(String name, LocalDate dob, String email, Integer age) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

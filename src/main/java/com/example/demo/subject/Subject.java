package com.example.demo.subject;
import com.example.demo.student.Student;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.*;

@Entity
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


    @ManyToMany
    @JoinTable(
            name="student_enrolled",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<Student>();

    @Column(name = "subject_name", nullable=false)
    private String name;

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

    @JsonManagedReference
    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", enrolledStudents=" + enrolledStudents +
                ", name='" + name + '\'' +
                '}';
    }

    public void enrollStudent(Student stu) {
        enrolledStudents.add(stu);
    }
}

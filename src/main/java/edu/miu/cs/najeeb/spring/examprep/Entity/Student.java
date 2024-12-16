package edu.miu.cs.najeeb.spring.examprep.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id@GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String studentId;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String studentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}

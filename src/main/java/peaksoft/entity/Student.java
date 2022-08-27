package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
@Getter@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "student_gen",
    strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "study_format")
    private String studyFormat;

    @ManyToOne
    private Course course;

    public Student(String firstName, String lastName, int phoneNumber,
                   String studentEmail, String studyFormat, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.studentEmail = studentEmail;
        this.studyFormat = studyFormat;
        this.course = course;
    }
}

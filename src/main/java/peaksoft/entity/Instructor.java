package peaksoft.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(generator = "instructor_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_gen",
    sequenceName = "instructor_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private int phoneNumber;
    @Column(name = "instructors_email")
    private String instructorsEmail;
    @Column(name = "instructors_specialization")
    private String instructorSpecialization;

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            mappedBy = "instructor")
    private List<Course> courses;

}

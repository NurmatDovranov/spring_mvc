package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter @Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
    sequenceName = "course_seq",
    allocationSize = 1)
    private Long Id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "date_of_start")
    private String dateOfStart;
    @Column(name = "course_duration")
    private String courseDuration;
    @Column(name = "course_image")
     private String courseImage;
    @Column(name = "course_description")
    private String courseDescription;


    @ManyToOne
    private Company company;
    @ManyToOne
    private Instructor instructor;

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            mappedBy = "course")
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            mappedBy = "course")
    private List<Lesson> lessons;

    public Course(String courseName, String dateOfStart,
                  String courseDuration, String courseImage,
                  String courseDescription, Company company) {
        this.courseName = courseName;
        this.dateOfStart = dateOfStart;
        this.courseDuration = courseDuration;
        this.courseImage = courseImage;
        this.courseDescription = courseDescription;
        this.company = company;

    }
}

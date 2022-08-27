package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(generator = "lesson_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_gen",
    sequenceName = "lesson_seq",
    allocationSize = 1)
    private Long id;
    @Column(name = "lesson_name")
     private String lessonName;

    @ManyToOne
    private Course course;

    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE},
            mappedBy = "lesson")
    private List<Task> tasks;

}

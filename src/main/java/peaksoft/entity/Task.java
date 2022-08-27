package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen",
    sequenceName = "task_seq",
    allocationSize = 1)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text")
    private String taskText;
    @Column(name = "task_deadline")
    private String taskDeadline;

    @ManyToOne
    private Lesson lesson;
}

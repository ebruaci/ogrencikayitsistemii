package com.kayitsistemi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_lesson")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGeneratorLesson")
    @SequenceGenerator(name = "seqGeneratorLesson", sequenceName = "lesson_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "capacity")
    private int capacity;
}

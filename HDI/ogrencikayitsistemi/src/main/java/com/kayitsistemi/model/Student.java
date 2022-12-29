package com.kayitsistemi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGeneratorStudent")
    @SequenceGenerator(name = "seqGeneratorStudent", sequenceName = "student_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}

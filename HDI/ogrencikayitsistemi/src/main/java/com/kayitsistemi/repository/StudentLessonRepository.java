package com.kayitsistemi.repository;

import com.kayitsistemi.model.Lesson;
import com.kayitsistemi.model.StudentLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
    int countByLesson(Lesson lesson);

}

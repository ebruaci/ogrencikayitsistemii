package com.kayitsistemi.service;

import com.kayitsistemi.model.StudentLesson;
import com.kayitsistemi.repository.StudentLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class StudentLessonService {

    @Autowired
    private StudentLessonRepository studentLessonRepository;

    public StudentLesson save(StudentLesson studentLesson) {
        if (Objects.isNull(studentLesson)) return null;

        int lessonCount = studentLessonRepository.countByLesson(studentLesson.getLesson());
        if (lessonCount > studentLesson.getLesson().getCapacity()) {
            throw new AssertionError("Kapasite bilgisi aşılmıştır");
        }

        if (Objects.isNull(studentLesson.getId())) {
            return studentLessonRepository.save(studentLesson);
        }

        return studentLesson;
    }

}

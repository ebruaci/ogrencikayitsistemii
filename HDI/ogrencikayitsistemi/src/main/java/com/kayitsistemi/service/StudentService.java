package com.kayitsistemi.service;

import com.kayitsistemi.model.Student;
import com.kayitsistemi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student) {
        if (Objects.isNull(student)) return null;

        if (Objects.isNull(student.getId())){
            return studentRepository.save(student);
        }
        return student;
    }

    public Student update(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudentList(){
        return studentRepository.findAll();
    }
}

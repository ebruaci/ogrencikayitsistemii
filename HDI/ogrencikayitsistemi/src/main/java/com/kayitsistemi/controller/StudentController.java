package com.kayitsistemi.controller;

import com.kayitsistemi.model.Student;
import com.kayitsistemi.repository.StudentRepository;
import com.kayitsistemi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody Student student) {
        try {
            studentService.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody Student student) {
        try {
            if (Objects.isNull(student.getId())){
                return ResponseEntity.badRequest().body("Güncellenecek kayıt bulunamamıştır");
            }

            studentService.update(student);

            return new ResponseEntity<>(student, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = {"/studentList"})
    public ResponseEntity studentList(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, @RequestParam(name = "status", defaultValue = "all") String status) {
        PageRequest pageRequest = PageRequest.of(page, Math.min(size, 100));
        Page pageResponse = studentRepository.findAll(pageRequest);

        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
}


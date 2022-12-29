package com.kayitsistemi.controller;

import com.kayitsistemi.model.StudentLesson;
import com.kayitsistemi.repository.StudentLessonRepository;
import com.kayitsistemi.service.StudentLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/studentLesson")
public class StudentLessonController {

    @Autowired
    private StudentLessonRepository studentLessonRepository;

    @Autowired
    StudentLessonService studentLessonService;

    @PostMapping("/create")
    public ResponseEntity create(@Valid @RequestBody StudentLesson studentLesson) {
        try {
            studentLessonService.save(studentLesson);
            return new ResponseEntity<>(studentLesson, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = {"/studentLessonList"})
    public ResponseEntity studentLessonList(@RequestParam(name = "page", defaultValue = "0") int page, @RequestParam(name = "size", defaultValue = "10") int size, @RequestParam(name = "status", defaultValue = "all") String status) {
        PageRequest pageRequest = PageRequest.of(page, Math.min(size, 100));
        Page pageResponse = studentLessonRepository.findAll(pageRequest);

        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
}

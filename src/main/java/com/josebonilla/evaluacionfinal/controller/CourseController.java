package com.josebonilla.evaluacionfinal.controller;

import com.josebonilla.evaluacionfinal.model.Course;
import com.josebonilla.evaluacionfinal.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> save(@Valid @RequestBody Course course){
        return new ResponseEntity<>(service.save(course), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@Valid @PathVariable("id") Integer id, @RequestBody Course course){
        return new ResponseEntity<>(service.update(course, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

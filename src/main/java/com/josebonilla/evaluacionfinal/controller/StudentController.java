package com.josebonilla.evaluacionfinal.controller;

import com.josebonilla.evaluacionfinal.model.Student;
import com.josebonilla.evaluacionfinal.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @GetMapping
    public ResponseEntity<List<Student>> readAll() throws Exception{
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) throws Exception{
        return new ResponseEntity<>(service.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Integer id, @RequestBody Student student) throws Exception{
        return new ResponseEntity<>(service.update(student, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

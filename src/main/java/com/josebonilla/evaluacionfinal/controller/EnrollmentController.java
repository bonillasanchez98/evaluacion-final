package com.josebonilla.evaluacionfinal.controller;

import com.josebonilla.evaluacionfinal.model.Enrollment;
import com.josebonilla.evaluacionfinal.service.IEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;

    @GetMapping
    public ResponseEntity<List<Enrollment>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Enrollment> save(@Valid @RequestBody Enrollment enrollment){
        return new ResponseEntity<>(service.save(enrollment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.readById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@Valid @PathVariable("id") Integer id, @RequestBody Enrollment enrollment){
        return new ResponseEntity<>(service.update(enrollment, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

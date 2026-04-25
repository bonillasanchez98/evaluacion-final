package com.josebonilla.evaluacionfinal.service.Impl;

import com.josebonilla.evaluacionfinal.model.Student;
import com.josebonilla.evaluacionfinal.repo.IStudentRepo;
import com.josebonilla.evaluacionfinal.repo.IGenericRepo;
import com.josebonilla.evaluacionfinal.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDOperationsImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}

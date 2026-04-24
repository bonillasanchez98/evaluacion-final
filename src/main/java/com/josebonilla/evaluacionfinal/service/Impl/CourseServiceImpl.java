package com.josebonilla.evaluacionfinal.service.Impl;

import com.josebonilla.evaluacionfinal.model.Course;
import com.josebonilla.evaluacionfinal.repo.ICourseRepo;
import com.josebonilla.evaluacionfinal.repo.IGenericRepo;
import com.josebonilla.evaluacionfinal.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDOperationsImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}

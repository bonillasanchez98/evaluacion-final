package com.josebonilla.evaluacionfinal.service.Impl;

import com.josebonilla.evaluacionfinal.model.Enrollment;
import com.josebonilla.evaluacionfinal.repo.IEnrollmentRepo;
import com.josebonilla.evaluacionfinal.repo.IGenericRepo;
import com.josebonilla.evaluacionfinal.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDOperationsImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}

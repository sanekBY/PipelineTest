package com.sashqua.pipeline.service.impl;

import com.sashqua.pipeline.entity.*;
import com.sashqua.pipeline.repository.ExecutionRepository;
import com.sashqua.pipeline.service.PipelineExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/8/17.
 */
@Service("executionService")
@Validated
public class PipelineExecutoinServiceImpl implements PipelineExecutionService {


    @Autowired
    private final ExecutionRepository repository;

    public PipelineExecutoinServiceImpl(ExecutionRepository repository) {
        this.repository = repository;
    }


    public Status getStatusOfExe(Integer id) {
        return null;
    }

    public Status stopExecution(Integer id) {
        return null;
    }

    @Override
    public Execution save(Execution execution) {
        return repository.save(execution);
    }

    @Override
    public Execution getExecution(Integer id) {
        Execution exe = repository.findOne(id);
        return exe;
    }

    @Override
    public void editExecution(Integer id) {

    }

    @Override
    public void editTaskStatus(Integer id, Status status, Date date) {
        repository.editExecutionStatus(id, status, date);
    }
}

package com.sashqua.pipeline.service.impl;

import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;
import com.sashqua.pipeline.repository.StatusRepository;
import com.sashqua.pipeline.repository.TaskRepository;
import com.sashqua.pipeline.service.PipelineStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/8/17.
 */
@Service("pipelineStatusService")
@Validated
public class PipelineStatuserviceImpl implements PipelineStatusService {

    @Autowired
    private StatusRepository repository;


    public PipelineStatuserviceImpl() {

    }

    @Override
    public List<Status> getAllStatuses() {
        return repository.findAll();
    }

    @Override
    public Status getStatus(Integer id) {
        Status st = repository.findOne(id);
        return st;
    }
}

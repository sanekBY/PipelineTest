package com.sashqua.pipeline.service.impl;

import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.repository.PipelineRepository;
import com.sashqua.pipeline.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * Created by sashqua on 2/8/17.
 */
@Service("pipelineService")
@Validated
public class PipelineServiceImpl implements PipelineService {

    @Autowired
    private final PipelineRepository repository;

    public PipelineServiceImpl(PipelineRepository pipelineRepository) {
        this.repository = pipelineRepository;
    }

    @Override
    public Pipeline save(Pipeline pipeline) {
        return repository.save(pipeline);
    }

    @Override
    public Pipeline getPipeline(Integer id) {
        Pipeline pipeline = repository.findOne(id);
        return pipeline;
    }

    @Override
    public Pipeline getPipelineByName(String name) {
        return null;
    }

    @Override
    public void editPipeline(Integer id) {

    }
}

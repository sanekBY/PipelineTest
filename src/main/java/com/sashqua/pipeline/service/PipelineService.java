package com.sashqua.pipeline.service;

import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.entity.Status;

/**
 * Created by sashqua on 2/8/17.
 */
public interface PipelineService {
    Pipeline save(Pipeline pipeline);
    Pipeline getPipeline(Integer id);
    Pipeline getPipelineByName(String name);
    void editPipeline(Integer id);
}

package com.sashqua.pipeline.service;

import com.sashqua.pipeline.entity.Execution;
import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.entity.Status;

import java.util.Date;

/**
 * Created by sashqua on 2/8/17.
 */
public interface PipelineExecutionService {
    Execution save(Execution execution);
    Execution getExecution(Integer id);
    void editExecution(Integer id);
    void editTaskStatus(Integer id, Status status, Date date);
}

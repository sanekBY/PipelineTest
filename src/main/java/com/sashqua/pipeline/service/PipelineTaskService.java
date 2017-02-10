package com.sashqua.pipeline.service;

import com.sashqua.pipeline.entity.Execution;
import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/8/17.
 */

public interface PipelineTaskService {
    Task save(Task execution);
    Task getTask(Integer id);
    void editTaskStatus(Integer id, Status status, Date startTime, Date endTime);
    void editAllTasks(List<Task> tasks);
}

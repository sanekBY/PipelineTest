package com.sashqua.pipeline.service.impl;

import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;
import com.sashqua.pipeline.repository.TaskRepository;
import com.sashqua.pipeline.service.PipelineTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/8/17.
 */
@Service("pipelineTaskService")
@Validated
public class PipelineTaskServiceImpl implements PipelineTaskService {

    @Autowired
    private TaskRepository repository;


    public PipelineTaskServiceImpl() {

    }

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public Task getTask(Integer id) {
        Task t = repository.findOne(id);
        return t;
    }

    @Override
    public void editTaskStatus(Integer id, Status status, Date start, Date end) {
        repository.editTaskStatus(id, status, start, end);
    }

    @Override
    public void editAllTasks(List<Task> tasks) {
        for (Task task: tasks) {
//            if (task.getStartTime() == null) task.setStartTime(null);
//            if (task.getEndTime() == null) task.setEndTime(null);
            repository.editTaskStatus(task.getId(), task.getStatusId(), task.getStartTime(), task.getEndTime());
        }
    }


}

package com.sashqua.pipeline.controller;

import com.sashqua.pipeline.config.AppConfig;
import com.sashqua.pipeline.entity.*;
import com.sashqua.pipeline.service.PipelineExecutionService;
import com.sashqua.pipeline.service.PipelineService;
import com.sashqua.pipeline.service.PipelineStatusService;
import com.sashqua.pipeline.service.PipelineTaskService;
import com.sashqua.pipeline.thread.TaskExecute;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/7/17.
 */
@Controller
public class ExecutionController extends Thread {

    @Autowired
    private final PipelineService pipelineService;
    @Autowired
    private final PipelineExecutionService executionService;
    @Autowired
    private final PipelineTaskService pipelineTaskService;
    @Autowired
    private final PipelineStatusService pipelineStatusService;

    private static final Logger logger = Logger.getLogger(ExecutionController.class);
    private Execution execution;
    private List<Status> allStatuses;

    @Autowired
    public ExecutionController(PipelineService pipelineService, PipelineExecutionService pipelineExecutionService, PipelineTaskService pipelineTaskService, PipelineStatusService pipelineStatusService) {
        this.pipelineService = pipelineService;
        this.executionService = pipelineExecutionService;
        this.pipelineTaskService = pipelineTaskService;
        this.pipelineStatusService = pipelineStatusService;
    }


    /* Pipeline execution */
    public Status execute(Pipeline pipeline){
        try {
            if (pipeline != null) {
                initialize(pipeline);
                List<Task> allTasks = new ArrayList<>();
                allTasks.addAll(pipeline.getTasks());
                if (allTasks != null && !allTasks.isEmpty()){
                    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                    ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context.getBean("taskExecutor");
                    TaskExecute taskExecute = (TaskExecute) context.getBean(TaskExecute.class);
                    for (Task task: allTasks){

                        /*Multithreading task execution */
//                        taskExecute.setTask(task);
//                        taskExecutor.execute(taskExecute);
//                        task.setStatusId(pipelineStatusService.getStatus(taskExecute.getTask().getStatusId().getId()));
                        /**********************************/

                        logger.info("Task " + task.getName() + " started at " + task.getStartTime());
                        task.setStartTime(new Date());//
                        task.setStatusId(pipelineStatusService.getStatus(taskExecute.execute(task).getId()));
                        task.setEndTime(new Date());
                        logger.info("Task " + task.getName() + " completed at " + task.getEndTime() + " With status: " + task.getStatusId().getName());
                        if (!checkStatus(task)) {
                            execution.setStatusId(pipelineStatusService.getStatus(Status.FAILED));
                            break;
                        }
                    }
                    execution.setEndTime(new Date());
                    if (execution.getStatusId().getId() == Status.PENDING) {
                        execution.setStatusId(pipelineStatusService.getStatus(Status.COMPLETED));
                    }
                    executionService.editTaskStatus(execution.getId(),execution.getStatusId(), execution.getEndTime());
                    pipelineTaskService.editAllTasks(allTasks);
                    logger.info("Execution of pipeline " + execution.getPipelineId().getName() + " completed at " + execution.getEndTime() + " With status: " + execution.getStatusId().getName());
                    return   execution.getStatusId();
                }
            }
        }catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    /* Checking status of finished task */
    public boolean checkStatus(Task task) {
        if (task.getStatusId().getId() == Status.SKIPPED || task.getStatusId().getId() == Status.COMPLETED) {
            return true;
        } else if (task.getStatusId().getId() == Status.FAILED) {
            return false;
        } return true;
    }

    /* Execution initialize */
    public void initialize(Pipeline pipeline) {
        try {
            Status pending = pipelineStatusService.getStatus(Status.PENDING);
            execution = new Execution();
            execution.setStartTime(new Date());
            execution.setPipelineId(pipeline);
            execution.setStatusId(pending);
            List<Task> tasks = pipeline.getTasks();
            for (Task task : tasks) {
                task.setStatusId(pending);
            }
            pipelineTaskService.editAllTasks(tasks);
            executionService.save(execution);
            logger.info("Execution of pipeline  " + execution.getPipelineId().getName() + " started at " + execution.getStartTime());
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }


}

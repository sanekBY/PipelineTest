package com.sashqua.pipeline.thread;

import com.sashqua.pipeline.entity.Action;
import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Random;

/**
 * Created by sashqua on 2/9/17.
 */
@Component
@Scope("prototype")
public class TaskExecute extends Thread{

    Task task;

    public TaskExecute() {}

    /* Execute of task*/
    public Status execute(Task task) {
        try {
            if (task.getActionId().getId() == Action.Print) {
                System.out.println(task.getName());
                task.setStatusId(new Status(Status.COMPLETED));
            } else if (task.getActionId().getId() == Action.Random) {
                System.out.println(task.getName());
                // SLEEP THREAD 1 sec
                Thread.sleep(1000);
                task.setStatusId(new Status(new Random().nextInt(5)+1));
            } else if (task.getActionId().getId() == Action.Completed) {
                System.out.println(task.getName());
                //SLEEP THREAD 1 sec
                Thread.sleep(1000);
                task.setStatusId(new Status(Status.COMPLETED));
            } else if (task.getActionId().getId() == Action.Delayed) {
                System.out.println(task.getName());
                //SLEEP THREAD 10 sec
                Thread.sleep(10000);
                task.setStatusId(new Status(Status.COMPLETED));
            } else System.out.println("INVALID ACTION!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return task.getStatusId();
    }

    @Override
    public void run() {
        execute(task);
    }

    public void setTask(Task task) {
        this.task = task;
    }
    public Task getTask() {return task;}
}

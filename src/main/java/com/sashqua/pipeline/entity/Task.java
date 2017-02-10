package com.sashqua.pipeline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sashqua on 2/7/17.
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TaskSeq")
    @SequenceGenerator(name="TaskSeq", sequenceName="seq_task", allocationSize=1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id")
    private Action actionId;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pipeline_id")
    private Pipeline pipelineId;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status statusId;

    public Task(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }

    public Pipeline getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Pipeline pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

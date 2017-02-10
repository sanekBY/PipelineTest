package com.sashqua.pipeline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sashqua on 2/8/17.
 */
@Entity
@Table(name = "execution")
public class Execution implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ExeSeq")
    @SequenceGenerator(name="ExeSeq", sequenceName="seq_exe", allocationSize=1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status statusId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pipeline_id")
    private Pipeline pipelineId;

    public Execution() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Pipeline getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Pipeline pipelineId) {
        this.pipelineId = pipelineId;
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

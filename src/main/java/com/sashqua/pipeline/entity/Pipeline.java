package com.sashqua.pipeline.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by sashqua on 2/7/17.
 */
@Entity
@Table(name = "pipeline")
public class Pipeline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PipelineSeq")
    @SequenceGenerator(name="PipelineSeq", sequenceName="seq_pipeline", allocationSize=1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pipelineId", cascade = CascadeType.ALL)
    private List<Task> tasks;




    public Pipeline(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

package com.sashqua.pipeline.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sashqua on 2/7/17.
 */

@Entity
@Table(name = "action")
public class Action implements Serializable {

    public final static int Print = 1;
    public final static int Random = 2;
    public final static int Completed = 3;
    public final static int Delayed = 4;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ActionSeq")
    @SequenceGenerator(name="ActionSeq", sequenceName="seq_action", allocationSize=1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actionId")
    private Collection<Task> taskCollection;


    public Action() {}

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

    public Collection<Task> getTaskCollection() {
        return taskCollection;
    }

    public void setTaskCollection(Collection<Task> taskCollection) {
        this.taskCollection = taskCollection;
    }
}

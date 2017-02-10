package com.sashqua.pipeline.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sashqua on 2/8/17.
 */
@Entity
@Table(name = "status")
public class Status implements Serializable {

    public final static int PENDING = 1;
    public final static int IN_PROGRESS = 2;
    public final static int SKIPPED = 3;
    public final static int FAILED = 4;
    public final static int COMPLETED = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="StatusSeq")
    @SequenceGenerator(name="StatusSeq", sequenceName="seq_status", allocationSize=1)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;

    public Status() {

    }
    public Status(Integer id) {
        this.id = id;
    }


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
}

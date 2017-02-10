package com.sashqua.pipeline.repository;

import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sashqua on 2/8/17.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Modifying
    @Query("UPDATE Task t SET t.statusId = :status, t.startTime = :startTime, t.endTime = :endTime where t.id = :id")
    @Transactional
    void editTaskStatus(@Param("id") Integer id, @Param("status") Status status, @Param("startTime")Date start, @Param("endTime")Date end);
}

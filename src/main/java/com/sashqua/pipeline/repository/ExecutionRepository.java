package com.sashqua.pipeline.repository;

import com.sashqua.pipeline.entity.Execution;
import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.entity.Status;
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
public interface ExecutionRepository extends JpaRepository<Execution, Integer> {
    @Modifying
    @Query("UPDATE Execution e SET e.statusId = :status, e.endTime = :date where e.id = :id")
    @Transactional
    void editExecutionStatus(@Param("id") Integer id, @Param("status") Status status, @Param("date") Date date);


}

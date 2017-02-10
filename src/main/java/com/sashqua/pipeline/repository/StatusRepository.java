package com.sashqua.pipeline.repository;

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
public interface StatusRepository extends JpaRepository<Status, Integer> {

}

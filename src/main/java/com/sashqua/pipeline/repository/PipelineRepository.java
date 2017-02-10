package com.sashqua.pipeline.repository;

import com.sashqua.pipeline.entity.Pipeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by sashqua on 2/8/17.
 */
@Repository
public interface PipelineRepository extends JpaRepository<Pipeline, Integer> {

}

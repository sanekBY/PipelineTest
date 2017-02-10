package com.sashqua.pipeline.service;

import com.sashqua.pipeline.entity.Status;
import com.sashqua.pipeline.entity.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by sashqua on 2/8/17.
 */

public interface PipelineStatusService {
    List<Status> getAllStatuses();
    Status getStatus(Integer id);
}

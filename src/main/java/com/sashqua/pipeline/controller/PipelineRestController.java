package com.sashqua.pipeline.controller;

import com.sashqua.pipeline.entity.Pipeline;
import com.sashqua.pipeline.entity.Task;
import com.sashqua.pipeline.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sashqua on 2/7/17.
 */
@RestController
public class PipelineRestController {

    @Autowired
    private final PipelineService pipelineService;

    @Autowired
    private ExecutionController executionController;

    public PipelineRestController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @RequestMapping("/test")
    public Pipeline pipeline() {
        Pipeline pipeline = new Pipeline();
        pipeline = pipelineService.getPipeline(1);
        executionController.execute(pipeline);
        return null;
    }

}

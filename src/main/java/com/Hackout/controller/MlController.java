package com.Hackout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackout.response_request.BatchScoreRequest;
import com.Hackout.response_request.BatchScoreResponse;
import com.Hackout.response_request.ShapExplainRequest;
import com.Hackout.response_request.ShapExplainResponse;
import com.Hackout.response_request.SingleScoreRequest;
import com.Hackout.response_request.SingleScoreResponse;
import com.Hackout.services.MlService;

@RestController
@RequestMapping("/ml")
public class MlController {

    @Autowired
    private MlService mlService;

    @PostMapping("/score/batch")
    public BatchScoreResponse batchScore(@RequestBody BatchScoreRequest request) {
        return mlService.batchScore(request);
    }

    @PostMapping("/score/single")
    public SingleScoreResponse singleScore(@RequestBody SingleScoreRequest request) {
        return mlService.singleScore(request);
    }

    @PostMapping("/shap/explain")
    public ShapExplainResponse explainShap(@RequestBody ShapExplainRequest request) {
        return mlService.explainShap(request);
    }
}

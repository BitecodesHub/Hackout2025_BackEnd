package com.Hackout.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackout.response_request.BatchScoreRequest;
import com.Hackout.response_request.BatchScoreResponse;
import com.Hackout.response_request.ShapExplainRequest;
import com.Hackout.response_request.ShapExplainResponse;
import com.Hackout.response_request.SingleScoreRequest;
import com.Hackout.response_request.SingleScoreResponse;

@Service
public class MlService {
    @Autowired
    private ApiClientService apiClient;

    public BatchScoreResponse batchScore(BatchScoreRequest request) {
        return apiClient.post("/ml/score/batch", request, BatchScoreResponse.class);
    }

    public ShapExplainResponse explainShap(ShapExplainRequest request) {
        return apiClient.post("/ml/shap/explain", request, ShapExplainResponse.class);
    }

    public SingleScoreResponse singleScore(SingleScoreRequest request) {
        return apiClient.post("/ml/score/single", request, SingleScoreResponse.class);
    }
}
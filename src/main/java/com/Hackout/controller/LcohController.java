package com.Hackout.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hackout.response_request.LcohCalculateRequest;
import com.Hackout.response_request.LcohCalculateResponse;
import com.Hackout.services.LcohService;

@RestController
@RequestMapping("/ml/lcoh")
public class LcohController {
    @Autowired
    private LcohService lcohService;
    int hell;

    @PostMapping("/calculate")
    public LcohCalculateResponse calculate(@RequestBody LcohCalculateRequest request) {
        return lcohService.calculate(request);
    }
}

package com.lendico.repayment_plan.controller;

import com.lendico.repayment_plan.pojos.InputParameters;
import com.lendico.repayment_plan.pojos.output;
import com.lendico.repayment_plan.service.CalculateAnnuity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RestApiController {

    CalculateAnnuity calculateAnnuity = new CalculateAnnuity();

    List<output> outputParameters;

    private static Logger logger = LoggerFactory.getLogger(RestController.class);

    @RequestMapping(value = "/generate-plan",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")

    public ResponseEntity<?> generatePlan(@RequestBody InputParameters body) {
        try {

            logger.info("Start the calculation");
            outputParameters = calculateAnnuity.process(body);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(outputParameters);
    }

}

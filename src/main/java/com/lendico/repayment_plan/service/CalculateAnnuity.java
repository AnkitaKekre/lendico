package com.lendico.repayment_plan.service;

import com.lendico.repayment_plan.pojos.InputParameters;
import com.lendico.repayment_plan.pojos.output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalculateAnnuity {

    private static Logger logger = LoggerFactory.getLogger(CalculateAnnuity.class);

    GeneratePlanService generatePlanService = new GeneratePlanService();

    public List<output> process(InputParameters inputParameters) {

        logger.info("Calculate Annuity");

        double ratePerPeriod = calculateRate(inputParameters.getRate());
        int durationInMonths = convertDuration(inputParameters.getDuration());

        double annuity = ((ratePerPeriod * inputParameters.getAmount()) / (1 - Math.pow((1 + ratePerPeriod), -durationInMonths)));

        return generatePlanService.generate(inputParameters, annuity);
    }

    public double calculateRate(double rate) {
        rate = rate / 1200;
        return rate;
    }

    public int convertDuration(int duration) {
        duration = duration * 12;
        return duration;
    }
}


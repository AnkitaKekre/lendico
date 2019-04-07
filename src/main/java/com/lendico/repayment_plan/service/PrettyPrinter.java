package com.lendico.repayment_plan.service;

import com.lendico.repayment_plan.pojos.output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrettyPrinter {

    private static Logger logger = LoggerFactory.getLogger(GeneratePlanService.class);


    public void print(List<output> outputList)
    {

        logger.info("Print Plan");

        System.out.println();
        System.out.println();
        System.out.println("The generated plan is as below");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (output out : outputList) {
            System.out.println("Date: " + out.getDate());
            System.out.println("Borrower Payment Amount: " + out.getBorrowerPaymentAmount());
            System.out.println("Principal: " + out.getPrincipal());
            System.out.println("Interest: " + out.getInterest());
            System.out.println("Initial Outstanding Principal: " + out.getInitialOutstandingPrincipal());
            System.out.println("Remaining Outstanding Principal: " + out.getRemainingOutstandingPrincipal());
            System.out.println();
            System.out.println(

                    "-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
}

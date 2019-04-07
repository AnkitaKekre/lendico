package com.lendico.repayment_plan.service;

import com.lendico.repayment_plan.pojos.InputParameters;
import com.lendico.repayment_plan.pojos.output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratePlanService {


    private static Logger logger = LoggerFactory.getLogger(GeneratePlanService.class);

    PrettyPrinter prettyPrinter = new PrettyPrinter();

    List<output> outputParameters = new ArrayList<output>();

    int daysInMonth = 30;
    int daysInYear = 360;
    DecimalFormat df = new DecimalFormat("###.##");

    public List<output> generate(InputParameters inputParameters, double annuity)
    {

        logger.info("Generate Plan");
        double borrowerPaymentAmount = Double.parseDouble(df.format(annuity));
        double initialOutstandingPrincipal = inputParameters.getAmount();
        double interest;
        double principal;
        double remainingOutstandingPrincipal;


        for(int i = 0; i<(inputParameters.getDuration()*12); i++) {


            output out = new output();

            /*Increment month in Date*/
            String stringDate = LocalDate
                    .parse(inputParameters.getPayout())
                    .plusMonths(i)
                    .toString();

            LocalDate date = formatDate(stringDate);

            initialOutstandingPrincipal = Double.parseDouble(df.format(initialOutstandingPrincipal));
            interest = Double.parseDouble(df.format(calculateInterest(inputParameters.getRate(), initialOutstandingPrincipal)));
            principal = Double.parseDouble(df.format(calculatePrincipal(borrowerPaymentAmount, interest)));

            if(principal > initialOutstandingPrincipal)
            {
                principal = initialOutstandingPrincipal;
                borrowerPaymentAmount = principal + interest;
            }
            remainingOutstandingPrincipal = Double.parseDouble(df.format(calculateOutstandingPrincipal(initialOutstandingPrincipal, principal)));

            out.setBorrowerPaymentAmount(borrowerPaymentAmount);
            out.setDate(date);
            out.setInitialOutstandingPrincipal(initialOutstandingPrincipal);
            out.setInterest(interest);
            out.setPrincipal(principal);
            out.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);

            outputParameters.add(out);

            initialOutstandingPrincipal = remainingOutstandingPrincipal;
        }


        prettyPrinter.print(outputParameters);

        return outputParameters;

    }

    public LocalDate formatDate(String dateInString)
    {
            LocalDate date = LocalDate.parse(dateInString);
            return date;
    }

    public double calculateInterest(double rate, double initialOutstandingPrincipal)
    {
        return ((rate * initialOutstandingPrincipal * daysInMonth)/(daysInYear*100));
    }

    public double calculatePrincipal(double annuity, double interest)
    {
        return (annuity - interest);
    }

    public double calculateOutstandingPrincipal(double initialOutstandingPrincipal, double principal)
    {
        return (initialOutstandingPrincipal - principal);
    }

}

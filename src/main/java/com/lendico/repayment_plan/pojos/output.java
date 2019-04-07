package com.lendico.repayment_plan.pojos;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;


@JsonPropertyOrder({
        "borrowerPaymentAmount",
        "date",
        "initialOutstandingPrincipal",
        "interest",
        "principal",
        "remainingOutstandingPrincipal"
})


public class output {

    @JsonProperty("borrowerPaymentAmount")
    private double borrowerPaymentAmount;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("initialOutstandingPrincipal")
    private double initialOutstandingPrincipal;

    @JsonProperty("interest")
    private double interest;

    @JsonProperty("principal")
    private double principal;

    @JsonProperty("remainingOutstandingPrincipal")
    private double remainingOutstandingPrincipal;

    public double getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }
}

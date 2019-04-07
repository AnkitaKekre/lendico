package com.lendico.repayment_plan.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "duration",
        "rate",
        "amount",
        "payout"
})


public class InputParameters {

    @JsonProperty("duration")
    private int duration;

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("payout")
    private String payout;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayout() {
        return payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }
}

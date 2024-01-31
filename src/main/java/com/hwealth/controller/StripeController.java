package com.hwealth.controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class StripeController {
    private final Gson gson = new Gson();
    
    static class CreatePaymentRequest {
        private Long amount;
        public Long getAmount() { return amount; }
        public void setAmount(Long amount) { this.amount = amount; }
    }

    
    static class CreatePaymentResponse {
        private String clientSecret;
        public CreatePaymentResponse(String clientSecret) { this.clientSecret = clientSecret; }
    }

    @PostMapping("/create-payment-intent")
    public String createPaymentIntent(@RequestBody CreatePaymentRequest requestData) throws StripeException {
    	
    	Stripe.apiKey = "sk_test_51NTUMQSCuUXEi5M25tvRjpTIskOxZASOPWEnuU2zPfQayWRrIIHpU7QUuHfa5hjORUsYp8Rcrzo7cyy5FlbqvjpV00cxvCJRdy";
    	
        PaymentIntent paymentIntent = PaymentIntent.create(
                PaymentIntentCreateParams.builder()
                        .setAmount(requestData.amount*100)
                        .setCurrency("inr")
                        .build()
        );
        return gson.toJson(new CreatePaymentResponse(paymentIntent.getClientSecret()));
    }

}

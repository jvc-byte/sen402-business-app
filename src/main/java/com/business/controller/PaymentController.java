package com.business.controller;

import com.business.entity.Payment;
import com.business.repository.PaymentRepository;
import com.business.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public String listPayments(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("newPayment", new Payment());
        return "payments";
    }

    @PostMapping
    public String addPayment(@ModelAttribute Payment payment) {
        paymentRepository.save(payment);
        return "redirect:/payments";
    }
}

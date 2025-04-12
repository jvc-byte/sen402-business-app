package com.business.controller;

import com.business.entity.Supplier;
import com.business.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public String listSuppliers(Model model) {
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("newSupplier", new Supplier());
        return "suppliers";
    }

    @PostMapping
    public String addSupplier(@ModelAttribute Supplier supplier) {
        supplierRepository.save(supplier);
        return "redirect:/suppliers";
    }
}

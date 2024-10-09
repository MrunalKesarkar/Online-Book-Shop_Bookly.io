package com.bookly.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookly.dto.DiscountDTO;

import com.bookly.services.DiscountService;

@RestController
@RequestMapping("/discounts")
@CrossOrigin(origins = "*")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping
    public ResponseEntity<?> getAllDiscounts() {
        List<DiscountDTO> discounts = discountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/{discount_id}")
    public ResponseEntity<?> getDiscountById(@PathVariable Long discount_id) {
        DiscountDTO discount = discountService.getDiscountById(discount_id);
        return ResponseEntity.ok(discount);
    }

    @PostMapping
    public ResponseEntity<?> createOrUpdateDiscount(@RequestBody DiscountDTO discountDTO) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(discountService.createOrUpdateDiscount(discountDTO));
    }

    @DeleteMapping("/{discount_id}")
    public ResponseEntity<?> deleteDiscount(@PathVariable Long discount_id) {
        return ResponseEntity.ok(discountService.deleteDiscount(discount_id));
    }

    
    }


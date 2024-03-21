package com.banco.controllers;

import com.banco.services.LoanServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@AllArgsConstructor
public class LoanController {
    LoanServiceImpl loanService;

    @GetMapping
    public ResponseEntity<?> getLoans(){
        return ResponseEntity.ok(loanService.getLoans());
    }
}

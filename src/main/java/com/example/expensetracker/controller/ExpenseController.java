package com.example.expensetracker.controller;

import com.example.expensetracker.entity.ExpenseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.example.expensetracker.service.ExpenseService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping("/list")
    public List<ExpenseEntity> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping("/create")
    public ExpenseEntity createExpense(@RequestBody ExpenseEntity expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping("/filterByRange/{startDate}/{endDate}")
    public List<ExpenseEntity> filterByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {

        return expenseService.filterByDate(startDate, endDate);
    }
    @GetMapping("/{id}")
    public Optional<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseById(@PathVariable Long id) {
         expenseService.deleteById(id);
    }

    @GetMapping("/dummy")
    public String createExpense() {
        return "Dummy works!!";
    }
}

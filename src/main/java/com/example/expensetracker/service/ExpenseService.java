package com.example.expensetracker.service;

import com.example.expensetracker.entity.ExpenseEntity;
import com.example.expensetracker.repo.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseEntity> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseEntity createExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    public Optional<ExpenseEntity> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public void deleteById(Long id) {
         expenseRepository.deleteById(id);
    }
}

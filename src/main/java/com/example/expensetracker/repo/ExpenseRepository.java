package com.example.expensetracker.repo;

import com.example.expensetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
}

package com.example.expensetracker.repo;

import com.example.expensetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Long> {
    List<ExpenseEntity> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}

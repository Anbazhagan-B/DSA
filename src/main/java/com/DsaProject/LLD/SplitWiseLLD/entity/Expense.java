package com.DsaProject.LLD.SplitWiseLLD.entity;

import com.DsaProject.LLD.SplitWiseLLD.Strategy.SplitStrategy;

import java.time.LocalDateTime;
import java.util.*;

public class Expense {
    String id;
    String description;
    Double amount;
    User paidBy;
    List<Split> splits;
    LocalDateTime timestamp;

    public Expense(ExpenseBuilder builder)
    {
        this.id = builder.id;
        this.description = builder.description;
        this.amount = builder.amount;
        this.paidBy = builder.paidBy;
        this.timestamp = LocalDateTime.now();
        this.splits = builder.splitStrategy.calculateSplits(builder.amount, builder.paidBy, builder.participants, builder.splitValues);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public static class ExpenseBuilder
    {
        String id;
        String description;
        Double amount;
        User paidBy;
        List<User> participants;
        List<Double> splitValues;
        SplitStrategy splitStrategy;

        public ExpenseBuilder setId(String id)
        {
            this.id = id;
            return this;
        }

        public ExpenseBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder setPaidBy(User paidBy)
        {
            this.paidBy = paidBy;
            return this;
        }

        public ExpenseBuilder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public ExpenseBuilder setSplitStrategy(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
            return this;
        }

        public ExpenseBuilder setSplitValues(List<Double> splitValues)
        {
            this.splitValues = splitValues;
            return this;
        }

        public Expense build()
        {
            if(splitStrategy == null)
            {
                throw new IllegalArgumentException("Split strategy is required");
            }

            return new Expense(this);
        }
    }
}

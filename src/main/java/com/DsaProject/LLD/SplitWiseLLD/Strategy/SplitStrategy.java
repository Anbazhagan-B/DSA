package com.DsaProject.LLD.SplitWiseLLD.Strategy;

import com.DsaProject.LLD.SplitWiseLLD.entity.*;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplits(double totalAmount, User paidBy, List<User> participants, List<Double> splitValues);
}

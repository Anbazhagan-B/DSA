package com.DsaProject.LLD.FoodDeliveryServiceLLD.strategy;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.DeliveryAgent;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;

import java.util.List;
import java.util.Optional;

public interface DeliveryAssignmentStrategy {
    Optional<DeliveryAgent> findAgent(Order order, List<DeliveryAgent> agents);
}

package com.DsaProject.LLD.FoodDeliveryServiceLLD.strategy;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.Address;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.DeliveryAgent;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;

import java.util.*;
import java.util.Optional;

public class NearestAvailableAgentStrategy implements DeliveryAssignmentStrategy{

    @Override
    public Optional<DeliveryAgent> findAgent(Order order, List<DeliveryAgent> availableAgents)
    {
        Address restaurantAddress = order.getRestaurant().getAddress();
        Address customerAddress = order.getCustomer().getAddress();
        return  availableAgents.stream().filter(DeliveryAgent::isAvailable).min(Comparator.comparingDouble(agent -> calculateTotalDistance(agent, restaurantAddress, customerAddress)));
    }

    private double calculateTotalDistance(DeliveryAgent agent, Address restaurantAddress, Address customerAddress)
    {
        double agentToRestaurantDist = agent.getCurrentLocation().distanceTo(restaurantAddress);
        double restaurantToCustomerDist = restaurantAddress.distanceTo(customerAddress);
        return agentToRestaurantDist + restaurantToCustomerDist;

    }
}

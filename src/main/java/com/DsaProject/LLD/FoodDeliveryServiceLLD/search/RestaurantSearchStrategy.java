package com.DsaProject.LLD.FoodDeliveryServiceLLD.search;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.Restaurant;

import java.util.List;

public interface RestaurantSearchStrategy {
    List<Restaurant> filter(List<Restaurant> allRestaurants);
}

package com.DsaProject.LLD.FoodDeliveryServiceLLD.search;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByMenuKeywordStrategy implements RestaurantSearchStrategy {
    private final String keyword;

    public SearchByMenuKeywordStrategy(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public List<Restaurant> filter(List<Restaurant> allRestaurants) {
        return allRestaurants.stream()
                .filter(r -> r.getMenu().getItems().values().stream()
                        .anyMatch(item -> item.getName().toLowerCase().contains(keyword)))
                .collect(Collectors.toList());
    }
}

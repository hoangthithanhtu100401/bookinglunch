package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.dto.request.RestaurantRequest;
import com.hivetech.bookinglunch.dto.request.UpdateRestaurantRequest;
import com.hivetech.bookinglunch.dto.response.RestaurantResponse;

public interface RestaurantService {

    void saveRestaurant(RestaurantRequest request);

    RestaurantResponse getRestaurantById(Integer restaurantId);

    void updateRestaurant(UpdateRestaurantRequest  request);

    void deleteRestaurant(Integer restaurantId);
}

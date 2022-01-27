package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.dto.request.RestaurantRequest;
import com.hivetech.bookinglunch.dto.request.UpdateRestaurantRequest;
import com.hivetech.bookinglunch.dto.response.RestaurantResponse;
import com.hivetech.bookinglunch.dto.response.SetsResponse;
import com.hivetech.bookinglunch.entity.Restaurant;
import com.hivetech.bookinglunch.entity.Sets;
import com.hivetech.bookinglunch.repository.RestaurantRepository;
import com.hivetech.bookinglunch.repository.SetsRepository;
import com.hivetech.bookinglunch.service.RestaurantService;
import com.hivetech.bookinglunch.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    SetsService setsService;

    @Autowired
    private SetsRepository setsRepository;

    @Override
    public void saveRestaurant(RestaurantRequest request) {
        Restaurant restaurant = Restaurant.builder()
                .restaurantName(request.getRestaurantName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .status(request.getStatus())
                .build();
        restaurantRepository.save(restaurant);
        for (int i = 0; i < request.getSets().size(); i++) {
            Sets set = Sets.builder()
                    .setName(request.getSets().get(i).getSetName())
                    .description(request.getSets().get(i).getDescription())
                    .status(true)
                    .restaurant(restaurant)
                    .build();
            setsService.saveSets(set);
        }
    }

    @Override
    public RestaurantResponse getRestaurantById(Integer restaurantId) {
        List<Sets> sets = setsRepository.findSetsByRestaurantId(restaurantId);
        ArrayList<SetsResponse> responses = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++) {
            SetsResponse setsResponse = SetsResponse.builder()
                    .setId(sets.get(i).getSetId())
                    .setName((sets.get(i).getSetName()))
                    .description(sets.get(i).getDescription())
                    .build();
            responses.add(setsResponse);
        }

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        RestaurantResponse restaurants = RestaurantResponse.builder()
                .restaurantName(restaurant.get().getRestaurantName())
                .address(restaurant.get().getAddress())
                .phoneNumber(restaurant.get().getPhoneNumber())
                .status(restaurant.get().getStatus())
                .sets(responses)
                .build();

        return restaurants;
    }

    @Override
    public void updateRestaurant(UpdateRestaurantRequest request) {

        Restaurant restaurant = restaurantRepository.getById(request.getRestaurantId());
        restaurant.setRestaurantName(request.getRestaurantName());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setAddress(request.getAddress());
        restaurant.setStatus(request.getStatus());

        restaurantRepository.save(restaurant);
        for (int i= 0; i < request.getSets().size(); i++) {
            Sets set;
            if (request.getSets().get(i).getSetId() == null) {
                set = new Sets();
                set.setDescription(request.getSets().get(i).getDescription());
                set.setSetName(request.getSets().get(i).getSetName());
            } else {
                set = setsRepository.findBySetID(request.getSets().get(i).getSetId());
            }
            set.setStatus(true);
            set.setRestaurant(restaurant);
            setsService.saveSets(set);
        }
    }

    @Override
    public void deleteRestaurant(Integer restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

}


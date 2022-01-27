package com.hivetech.bookinglunch.controller;

import com.hivetech.bookinglunch.dto.request.RestaurantRequest;
import com.hivetech.bookinglunch.dto.request.UpdateRestaurantRequest;
import com.hivetech.bookinglunch.dto.response.RestaurantResponse;
import com.hivetech.bookinglunch.service.RestaurantService;
import com.hivetech.bookinglunch.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    SetsService setsService;

    @PostMapping("restaurant")
    public void saveRestaurant(@RequestBody RestaurantRequest request) {

        restaurantService.saveRestaurant(request);
    }

    @GetMapping("restaurant/detail/{restaurantId}")
    public RestaurantResponse getRestaurantById(@PathVariable int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    @PutMapping ("restaurant/set/{setId}")
    public String deleteSet(@PathVariable("setId") int setId, HttpServletRequest request) {
        setsService.deleteSets(setId);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @PutMapping("restaurant/update")
    public void changeRestaurant(@RequestBody UpdateRestaurantRequest request){
        restaurantService.updateRestaurant(request);
    }

    @DeleteMapping("restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId, HttpServletRequest request){
        restaurantService.deleteRestaurant(restaurantId);
        String referer = request.getHeader("referer");
        return "redirect:" + referer;
    }
}

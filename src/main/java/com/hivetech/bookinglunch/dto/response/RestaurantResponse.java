package com.hivetech.bookinglunch.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RestaurantResponse {
    private String restaurantName;
    private String address;
    private String phoneNumber;
    private Boolean status;
    private List<SetsResponse> sets;
}

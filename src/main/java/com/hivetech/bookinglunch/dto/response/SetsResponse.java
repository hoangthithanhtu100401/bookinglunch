package com.hivetech.bookinglunch.dto.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SetsResponse {
    private Integer setId;
    private String description;
    private String setName;
}
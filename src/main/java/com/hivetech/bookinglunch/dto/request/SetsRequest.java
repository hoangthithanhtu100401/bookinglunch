package com.hivetech.bookinglunch.dto.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

@Data
@JsonAutoDetect
public class SetsRequest {
    private Integer setId;
    private String description;
    private String setName;
}

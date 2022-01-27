package com.hivetech.bookinglunch.service;

import com.hivetech.bookinglunch.entity.Sets;

public interface SetsService {
    void saveSets(Sets sets);
    void deleteSets(int setId);
}

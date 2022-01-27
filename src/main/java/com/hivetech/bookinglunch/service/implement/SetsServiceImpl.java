package com.hivetech.bookinglunch.service.implement;

import com.hivetech.bookinglunch.entity.Sets;
import com.hivetech.bookinglunch.repository.SetsRepository;
import com.hivetech.bookinglunch.service.SetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetsServiceImpl implements SetsService {
    @Autowired
    SetsRepository setsRepository;

    @Override
    public void saveSets(Sets sets) {
        setsRepository.save(sets);
    }

    @Override
    public void deleteSets(int setId) {
        setsRepository.hideSet(setId);
    }
}

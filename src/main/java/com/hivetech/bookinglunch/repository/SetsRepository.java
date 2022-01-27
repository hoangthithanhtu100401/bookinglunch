package com.hivetech.bookinglunch.repository;

import com.hivetech.bookinglunch.entity.Restaurant;
import com.hivetech.bookinglunch.entity.Sets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SetsRepository extends JpaRepository<Sets, Integer> {

    @Transactional
    @Modifying
    @Query("select s from Sets s where s.restaurant.restaurantId =?1 ")
    List<Sets> findSetsByRestaurantId(Integer restaurantId);

    @Transactional
    @Modifying
    @Query("update Sets s set s.status = false where s.setId = ?1")
    void hideSet(int setId);

    @Query("SELECT s FROM Sets s WHERE s.setId = ?1")
    Sets findBySetID(int setId);
}

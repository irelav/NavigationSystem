package com.navigation.system.repository;

import com.navigation.system.entity.MobileStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;


public interface MobileStationRepository extends JpaRepository<MobileStation, Long> {
    @Query("select m from MobileStation m where m.mobileId = :mobileId")
    public MobileStation fetchMobileStationById(UUID mobileId);
}

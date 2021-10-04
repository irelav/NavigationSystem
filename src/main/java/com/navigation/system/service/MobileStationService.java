package com.navigation.system.service;

import com.navigation.system.entity.MobileStation;
import com.navigation.system.repository.MobileStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MobileStationService {

    @Autowired
    private MobileStationRepository mobileStationRepository;

    public MobileStation saveMobileStation(MobileStation mobileStation) {
        return mobileStationRepository.save(mobileStation);
    }

    public List<MobileStation> fetchMobileStationList() {
        return mobileStationRepository.findAll();
    }

    public MobileStation fetchMobileStationById(UUID mobileStationId) {
        return mobileStationRepository.fetchMobileStationById(mobileStationId);
    }
}

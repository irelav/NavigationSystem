package com.navigation.system.service;

import com.navigation.system.entity.BaseStation;
import com.navigation.system.repository.BaseStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseStationService {

    @Autowired
    private BaseStationRepository baseStationRepository;

    public BaseStation saveBaseStation(BaseStation baseStation) {
        return baseStationRepository.save(baseStation);
    }

    public List<BaseStation> fetchBaseStationList() {
        return baseStationRepository.findAll();
    }
}

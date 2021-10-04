package com.navigation.system.controller;

import com.navigation.system.entity.BaseStation;
import com.navigation.system.entity.MobileStation;
import com.navigation.system.entity.Report;
import com.navigation.system.service.BaseStationService;
import com.navigation.system.service.ConnectionService;
import com.navigation.system.service.MobileStationService;
import com.navigation.system.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class PositionController {

    @Autowired
    private MobileStationService mobileStationService;

    @Autowired
    private BaseStationService baseStationService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private ReportService reportService;

    @PostMapping("/basestation")
    public BaseStation saveBaseStation(@RequestBody BaseStation baseStation) {
        BaseStation baseStationTemp = baseStationService.saveBaseStation(baseStation);
        connectionService.pingMobileStations(baseStationTemp.getBaseId(),
                baseStationTemp.getX(), baseStationTemp.getY(), baseStationTemp.getDetectionRadiusInMeters());
        return baseStationTemp;
    }

    @PostMapping("/mobilestation")
    public MobileStation saveMobileStation(@RequestBody MobileStation mobileStation) {
        MobileStation mobileStationTemp = mobileStationService.saveMobileStation(mobileStation);
        connectionService.pingBaseStations(mobileStationTemp.getMobileId(),
                mobileStationTemp.getLastKnownX(), mobileStationTemp.getLastKnownY());
        return mobileStationTemp;
    }

    @GetMapping("/basestation")
    public List<BaseStation> fetchBaseStationList() {
        return baseStationService.fetchBaseStationList();
    }

    @GetMapping("/mobilestation")
    public List<MobileStation> fetchMobileStationList() {
        return mobileStationService.fetchMobileStationList();
    }

    //RestEndPoint1
    @GetMapping("/location")
    public List<Report> fetchReportList() {
        return reportService.fetchReportList();
    }
    //RestEndpoint2
    @GetMapping("/location/{id}")
    public MobileStation fetchMobileStationById(@PathVariable("id") UUID mobileStationId) {
        return mobileStationService.fetchMobileStationById(mobileStationId);
    }
}

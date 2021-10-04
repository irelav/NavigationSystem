package com.navigation.system.service;

import com.navigation.system.entity.BaseStation;
import com.navigation.system.entity.MobileStation;
import com.navigation.system.entity.Reports;
import com.navigation.system.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConnectionService {

    @Autowired
    private BaseStationService baseStationService;

    @Autowired
    private MobileStationService mobileStationService;

    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private ReportService reportService;

    public void pingBaseStations(UUID msId, float msX, float msY) {
        List<BaseStation> baseStationList = baseStationService.fetchBaseStationList();
        double distance;
        for (int i = 0; i < baseStationList.size(); i++) {
            distance = Math.sqrt((baseStationList.get(i).getX() - msX)
                    * (baseStationList.get(i).getX() - msX)
                    + (baseStationList.get(i).getY() - msY)
                    * (baseStationList.get(i).getY() - msY));
            if (distance <= baseStationList.get(i).getDetectionRadiusInMeters()) {
                Reports _reports = reportsRepository.save(new Reports(
                        msId, (float) distance));
                reportService.saveReport(_reports, baseStationList.get(i).getBaseId());
            }
        }
    }

    public void pingMobileStations(UUID bsId, float bsX, float bsY, float bsRadius) {
        List<MobileStation> mobileStationList = mobileStationService.fetchMobileStationList();
        double distance;
        if (!mobileStationList.isEmpty()) {
            for (int i = 0; i < mobileStationList.size(); i++) {
                distance = Math.sqrt((mobileStationList.get(i).getLastKnownX() - bsX)
                        * (mobileStationList.get(i).getLastKnownX() - bsX)
                        + (mobileStationList.get(i).getLastKnownY() - bsY)
                        * (mobileStationList.get(i).getLastKnownY() - bsY));
                if (distance <= bsRadius) {
                    Reports _reports = reportsRepository.save(new Reports(
                            mobileStationList.get(i).getMobileId(), (float) distance));
                    reportService.saveReport(_reports, bsId);
                }
            }
        }
    }

}

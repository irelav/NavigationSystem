package com.navigation.system.controller;

import com.navigation.system.entity.BaseStation;
import com.navigation.system.service.BaseStationService;
import com.navigation.system.service.ConnectionService;
import com.navigation.system.service.MobileStationService;
import com.navigation.system.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class PositionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private BaseStation baseStation;

    @MockBean
    private BaseStationService baseStationService;

    @MockBean
    private MobileStationService mobileStationService;

    @MockBean
    private ConnectionService connectionService;

    @MockBean
    private ReportService reportService;


    @BeforeEach
    void setUp() {
        baseStation =  new BaseStation(UUID.fromString("ac7c1684-9b13-4893-ae85-66d09391c5a0"),
                "BaseStation1", 2.0f, 1.0f, 5.0f);
    }

    @Test
    void saveBaseStation() throws Exception {
        BaseStation inputBaseStation = new BaseStation("BaseStation1", 2.0f, 1.0f, 5.0f);

        Mockito.when(baseStationService.saveBaseStation(inputBaseStation)).thenReturn(baseStation);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/basestation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"BaseStation1\",\n" +
                                "    \"x\": 2.0,\n" +
                                "    \"y\": 1.0,\n" +
                                "    \"detectionRadiusInMeters\": 5.0\n" +
                                "}")
                        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}

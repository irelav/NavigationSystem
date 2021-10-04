package com.navigation.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @Column(name = "base_station_id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID baseId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "report", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("report")
    private List<Reports> reportsList = new ArrayList<>();

    public Report() {

    }

    public UUID getBaseId() {
        return baseId;
    }

    public void setBaseId(UUID baseId) {
        this.baseId = baseId;
    }

    public List<Reports> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<Reports> reportsList) {
        this.reportsList = reportsList;
    }
}

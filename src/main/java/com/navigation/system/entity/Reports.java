package com.navigation.system.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mobile_station_id")
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID mobileId;

    @Column(name = "distance")
    private float distance;

    @Column(name = "timestamp")
    private LocalDateTime timeStamp;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "base_station_id", referencedColumnName = "base_station_id")
    private Report report;

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Reports() {

    }

    public Reports(UUID mobileId, float distance) {
        this.mobileId = mobileId;
        this.distance = distance;
        this.timeStamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getMobileId() {
        return mobileId;
    }

    public void setMobileId(UUID mobileId) {
        this.mobileId = mobileId;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id=" + id +
                ", mobileId=" + mobileId +
                ", distance=" + distance +
                ", timeStamp=" + timeStamp +
                ", report=" + report +
                '}';
    }
}

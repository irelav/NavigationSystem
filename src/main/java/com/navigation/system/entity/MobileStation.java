package com.navigation.system.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "mobilestation")
public class MobileStation {

    @Id
    @Column(name = "mobile_station_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID mobileId;

    @Column(name = "x")
    private float lastKnownX;

    @Column(name = "y")
    private float lastKnownY;

    public MobileStation() {
    }

    public MobileStation(UUID mobileId, float lastKnownX, float lastKnownY) {
        this.mobileId = mobileId;
        this.lastKnownX = lastKnownX;
        this.lastKnownY = lastKnownY;
    }

    public UUID getMobileId() {
        return mobileId;
    }

    public void setId(UUID mobileId) {
        this.mobileId = mobileId;
    }

    public float getLastKnownX() {
        return lastKnownX;
    }

    public void setLastKnownX(float lastKnownX) {
        this.lastKnownX = lastKnownX;
    }

    public float getLastKnownY() {
        return lastKnownY;
    }

    public void setLastKnownY(float lastKnownY) {
        this.lastKnownY = lastKnownY;
    }

    @Override
    public String toString() {
        return "MobileStation{" +
                "mobileId=" + mobileId +
                ", lastKnownX=" + lastKnownX +
                ", lastKnownY=" + lastKnownY +
                '}';
    }
}

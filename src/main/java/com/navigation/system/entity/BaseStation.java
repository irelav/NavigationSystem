package com.navigation.system.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "basestation")
public class BaseStation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID baseId;

    private String name;
    private float x;
    private float y;
    private float detectionRadiusInMeters;

    public BaseStation() {
    }

    public BaseStation(UUID baseId, String name, Float x, Float y, Float detectionRadiusInMeters) {
        this.baseId = baseId;
        this.name = name;
        this.x = x;
        this.y = y;
        this.detectionRadiusInMeters = detectionRadiusInMeters;
    }

    public BaseStation(String name, Float x, Float y, Float detectionRadiusInMeters) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.detectionRadiusInMeters = detectionRadiusInMeters;
    }

    public UUID getBaseId() {
        return baseId;
    }

    public void setBaseId(UUID baseId) {
        this.baseId = baseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDetectionRadiusInMeters() {
        return detectionRadiusInMeters;
    }

    public void setDetectionRadiusInMeters(float detectionRadiusInMeters) {
        this.detectionRadiusInMeters = detectionRadiusInMeters;
    }

    @Override
    public String toString() {
        return "BaseStation{" +
                "baseId=" + baseId +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", detectionRadiusInMeters=" + detectionRadiusInMeters +
                '}';
    }
}

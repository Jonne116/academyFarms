package dev.academy.academyFarms.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Instant dateTime;
    private String sensorType;
    private Float value;

    public Farm() {
    }

    public Farm(String location, Instant dateTime, String sensorType, Float value) {
        this.location = location;
        this.dateTime = dateTime;
        this.sensorType = sensorType;
        this.value = value;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Instant getDateTime() { return dateTime; }

    public void setDateTime(Instant dateTime) { this.dateTime = dateTime; }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "farm{" +
                "id=" + id +
                ", farm='" + location + '\'' +
                ", dataType='" + sensorType + '\'' +
                ", dataValue=" + value +
                '}';
    }
}

package dev.academy.academyFarms.farm;

import javax.persistence.*;

@Entity
@Table
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farm;
    private String dataType;
    private Double dataValue;

    public Farm() {
    }

    public Farm(String farm, String dataType, Double dataValue) {
        this.farm = farm;
        this.dataType = dataType;
        this.dataValue = dataValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Double getDataValue() {
        return dataValue;
    }

    public void setDataValue(Double dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "farm{" +
                "id=" + id +
                ", farm='" + farm + '\'' +
                ", dataType='" + dataType + '\'' +
                ", dataValue=" + dataValue +
                '}';
    }
}

package ru.sberbank.javaschool.transport.model;


import java.io.Serializable;
import java.time.ZonedDateTime;

public abstract class Transport implements Serializable {
    protected final String vin;
    protected ZonedDateTime createDate;
    protected Integer maxSpeed;
    protected Integer width;
    protected Integer height;
    protected Integer length;

    public Transport(String vin) {
        if (vin == null) {
            throw new IllegalArgumentException("Vin must be not null");
        }
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getLength() {
        return length;
    }

    //jackson ругается на getType т.к. не может найти поле
    public abstract TransportType takeType();


    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
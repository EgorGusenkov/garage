package ru.sberbank.javaschool.transport.model;


import java.time.ZonedDateTime;

public abstract class Transport {
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

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public abstract TransportType getType();


    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public void setMaxSpeed(int maxSpeed) {
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
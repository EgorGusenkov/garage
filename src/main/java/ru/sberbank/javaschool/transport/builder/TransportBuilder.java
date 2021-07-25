package ru.sberbank.javaschool.transport.builder;


import ru.sberbank.javaschool.transport.model.Transport;

public abstract class TransportBuilder<T extends Transport> {
    protected String vin;
    protected Integer maxSpeed;
    protected Integer width;
    protected Integer height;
    protected Integer length;

    public TransportBuilder<T> vin(String vin) {
        this.vin = vin;
        return this;
    }

    public TransportBuilder<T> maxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public TransportBuilder<T> length(int length) {
        this.length = length;
        return this;
    }

    public TransportBuilder<T> height(int height) {
        this.height = height;
        return this;
    }

    public TransportBuilder<T> width(int width) {
        this.width = width;
        return this;
    }

    public abstract T build();
}

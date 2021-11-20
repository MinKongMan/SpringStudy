package com.example.put.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @JsonProperty("car_number")
    private String carNumber;

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}

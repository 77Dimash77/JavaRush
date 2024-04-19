package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "motorbike"),
        @JsonSubTypes.Type(value = RacingBike.class, name = "race-bike")})
@JsonAutoDetect
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}
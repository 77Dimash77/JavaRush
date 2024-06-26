package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="className")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Car.class, name="com.javarush.task.task33.task3305.Car"),
})
@JsonAutoDetect
public class Car extends Vehicle {
}
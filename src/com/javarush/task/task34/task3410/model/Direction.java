package com.javarush.task.task34.task3410.model;

public enum Direction {
    LEFT, RIGHT, UP, DOWN;

    public static Direction getDirection(int x, int y){
        Direction direction = null;
        if(x > 0){
            direction = Direction.RIGHT;
        }else if(x< 0){
            direction = Direction.LEFT;
        }else if(y > 0){
            direction = Direction.DOWN;
        }else if(y < 0){
            direction = Direction.UP;
        }
        return direction;
    }
}

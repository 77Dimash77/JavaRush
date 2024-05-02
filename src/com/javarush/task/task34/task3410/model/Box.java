package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int left = getX() - getWidth() / 2;
        int top = getY() - getHeight() / 2;
        int right = getX() + getWidth() / 2;
        int bottom = getY() + getHeight() / 2;

        graphics.setColor(Color.ORANGE);
        graphics.drawRect(left, top, getWidth(), getHeight());
        graphics.drawLine(left, top, right, bottom);
        graphics.drawLine(left, bottom, right, top);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}

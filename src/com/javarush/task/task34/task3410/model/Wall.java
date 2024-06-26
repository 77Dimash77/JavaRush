package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Wall extends CollisionObject{
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        int left = getX() - getWidth() / 2;
        int top = getY() - getHeight() / 2;

        graphics.setColor(Color.GRAY);
        graphics.drawRect(left, top, getWidth(), getHeight());
        graphics.fillRect(left, top, getWidth(), getHeight());
    }
}

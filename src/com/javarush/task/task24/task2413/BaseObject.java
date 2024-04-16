package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    //methods

    public abstract void draw(Canvas canvas);
    public abstract void move();
   public boolean intersects(BaseObject o) {
        double d = Math.sqrt(Math.pow((this.x - o.x), 2) + Math.pow((this.y - o.y), 2));
        if (d <= this.radius || d <= o.radius) {
          return true;
        } else {
            return false;
        }
    }

    //STANDART POLE
   protected double x;
   protected double y;
   protected double radius;

   // STANDART CONSTRUCTOR

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    //STANDART METHODS


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

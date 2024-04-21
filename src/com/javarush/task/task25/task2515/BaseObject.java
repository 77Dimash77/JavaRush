package com.javarush.task.task25.task2515;

public abstract class BaseObject {
  protected double x;
  protected double y;
  protected double radius;
  protected boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void move(){
    }
    public void   draw(Canvas canvas){

    }
   public void die(){
        this.isAlive = false;
   }
    public boolean isIntersect(BaseObject o){
        if (Math.hypot(getX()-o.getX(), getY()-o.getY())< this.radius + o.radius){
            return true;
        } else {
            return false;
        }

    }
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}

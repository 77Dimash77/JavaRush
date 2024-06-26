package com.javarush.task.task24.task2413;

public class Ball extends BaseObject {

   private double speed;
   private double direction;

   private double dx;
   private double dy;
   private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    @Override
    public void draw(Canvas canvas) {
canvas.setPoint(getX(),getY(),'O');
    }

    @Override
    public void move() {
        if(isFrozen){

        }else {
            setX(getX()+dx);
            setY(getY() + dy);
        }

    }
    void start(){
        if(isFrozen){
            isFrozen = false;
        }
    }
    void checkRebound(int minx, int maxx, int miny, int maxy){

    }



    public Ball(double x, double y, double radius) {
        super(x, y, radius);

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = Math.sin(angel) * speed;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }
}

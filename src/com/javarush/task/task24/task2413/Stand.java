package com.javarush.task.task24.task2413;

public class Stand extends BaseObject  {
    private double speed;
 private double  direction;
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(),getY(),'_');
    }

    @Override
    public void move() {
    setX(getX() + speed * direction);
    }
    public void moveLeft(){
        direction = -1;
    }
    public void  moveRight(){
        direction = 1;
    }


    public Stand(double x, double y) { super(x, y, 3); speed = 1; direction = 0; }
    public Stand(double x, double y, double radius) {
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
    }
}

package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    //POLE1
    public static Arkanoid game;

    //GAME POLES
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    private boolean isGameOver;

    //METHODS

    public void run(){}


   public void checkBricksBump(){
        for (Brick b: bricks){
            boolean isTuk = b.intersects(ball);
            if(isTuk){
                double angle = Math.random() * 360;
                ball.setDirection(angle);
                bricks.remove(b);
                break;
            }


        }
    }
   public void checkStandBump(){
       boolean isTuk = ball.intersects(stand);
       if(isTuk){
           double angle = 90 + 20 *(Math.random() - 0.5);
           ball.setDirection(angle);
       }
    }
    public void  checkEndGame(){
        if(ball.getY() > height){
            isGameOver = true;
        }
    }
    public void move(){
        stand.move();
        ball.move();
    }
    public void draw(Canvas canvas){
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick b: bricks){
            b.draw(canvas);
        }
    }


    //GAME METHODS

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    // STANDART POLE
    private int width;
    private int height;

    // STANDART CONSTRUCTORS

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    // STANDART METODS
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
    }
}

package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

   public Snake(int x, int y){
        sections = new ArrayList<>();
        SnakeSection snakeSection = new SnakeSection(x,y);
        sections.add(snakeSection);
        isAlive = true;
    }
    int getX(){
        return sections.get(0).getX();
    }
    int getY(){
        return sections.get(0).getY();
    }
    void move(){
        if(!isAlive()){

        } else if (direction == SnakeDirection.UP) {
           move(0,-1);
        }else if (direction == SnakeDirection.RIGHT) {
      move(1,0);
        }else if (direction == SnakeDirection.DOWN) {
           move(0,1);
        }else if (direction == SnakeDirection.LEFT) {
            move(-1,0);
        }

    }
    void move(int dx, int dy) {
        //Создаем новую голову - новый "кусочек змеи".
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        //Проверяем - не вылезла ли голова за границу комнаты
        checkBorders(head);
        if (!isAlive) {
            return;
        }

        //Проверяем - не пересекает ли змея  саму себя
        checkBody(head);
        if (!isAlive) {
            return;
        }

        //Проверяем - не съела ли змея мышь.
        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) //съела
        {
            sections.add(0, head);                  //Добавили новую голову
            Room.game.eatMouse();                   //Хвот не удаляем, но создаем новую мышь.
        } else //просто движется
        {
            sections.add(0, head);                  //добавили новую голову
            sections.remove(sections.size() - 1);   //удалили последний элемент с хвоста
        }
    }


    public void checkBorders(SnakeSection head){
  int x = head.getX();
  int y = head.getY();
      if (x < 0 || y < 0 || x >= Room.game.getWidth() || y >= Room.game.getHeight())
          isAlive = false;

   }
   public void checkBody(SnakeSection head){

       for (SnakeSection s: sections){
           if(s.equals(head)){
               isAlive = false;
           }
       }
   }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public void setSections(List<SnakeSection> sections) {
        this.sections = sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}

package com.javarush.task.task23.task2312;

public class Room {
    private int width;
    private int height;
   private Snake snake;
  private   Mouse mouse;

  static Room game;


  void run(){}
    void print(){
      int[][] matrix = new int[height][width];
      matrix[snake.getY()][snake.getX()] = 2;
        if(snake.getSections().size()>1){
            for (int i = 1; i < snake.getSections().size(); i++) {
                matrix[snake.getSections().get(i).getY()][snake.getSections().get(i).getX()] = 1;
            }
        }
        matrix[mouse.getY()][mouse.getX()] = 3;
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j] == 1){
                    System.out.print("x");
                    
                } else if (matrix[i][j] == 2) {
                    System.out.print("X");
                } else if (matrix[i][j] == 3) {
                    System.out.print("^");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    void sleep() throws InterruptedException {
      int size = snake.getSections().size();
      int pspeed = 20;
      if(size<=15){
          Thread.sleep(520 - (pspeed * size));
      }else {
          Thread.sleep(200);
      }

      }


    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }
   public void createMouse(){
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
       mouse = new Mouse(x,y);
    }
    void eatMouse(){
      createMouse();
    }





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

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public static void main(String[] args) {
    Snake snake1 = new Snake(1,1);
    game = new Room(10,10,snake1);
    snake1.setDirection(SnakeDirection.DOWN);
    game.createMouse();
    game.run();
    }
}

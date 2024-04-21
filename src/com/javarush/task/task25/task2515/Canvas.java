package com.javarush.task.task25.task2515;

public class Canvas {
   private int width;
   private int height;
   private char [][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }
    public void setPoint(double x, double y, char c){
        if( (0 <= x && x < matrix[0].length) && (0 <= y && y < matrix.length)){
            int xx = (int)Math.round(x);
            int yy = (int)Math.round(y);
            this.matrix[yy][xx] = c;
        }

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);

                }
            }
        }
    }
    public void clear(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = ' ';
            }
        }
    }
    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
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

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}

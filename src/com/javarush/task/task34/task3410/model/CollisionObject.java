package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        if(gameObject == null || direction == null){
            return false;
        }

        int newX = getX();
        int newY = getY();

        switch (direction) {
            case UP:
                newY -= Model.FIELD_CELL_SIZE;
                break;
            case DOWN:
                newY += Model.FIELD_CELL_SIZE;
                break;
            case LEFT:
                newX -= Model.FIELD_CELL_SIZE;
                break;
            case RIGHT:
                newX += Model.FIELD_CELL_SIZE;
                break;
        }

        return gameObject.getX() == newX && gameObject.getY() == newY;
    }
}

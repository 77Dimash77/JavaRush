package com.javarush.task.task35.task3513;

/**

 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;  // number of empty tiles after move
    private int score; // score after move
    private Move move; // contains move (up or down or left or right)

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency another) {
        if (this.numberOfEmptyTiles != another.numberOfEmptyTiles) {
            return Integer.compare(this.numberOfEmptyTiles, another.numberOfEmptyTiles);
        } else {
            return Integer.compare(this.score, another.score);
        }
    }
}

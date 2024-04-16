package com.javarush.task.task35.task3513;
import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    Stack<Tile[][]> previousStates = new Stack<>();
    Stack<Integer> previousScores = new Stack<>();
    protected int score;
    protected int maxTile;
    boolean isSaveNeeded = true;

    public Tile[][] getGameTiles() { return gameTiles; }

    public Model() {
        resetGameTiles();
    }
    // Предлагаю создать приватный метод addTile, который будет смотреть какие плитки пустуют и,
    // если такие имеются, менять вес одной из них, выбранной случайным образом, на 2 или 4
    // (на 9 двоек должна приходиться 1 четверка). Получить случайный объект из списка можешь
    // использовав следующее выражение:
    //(размер Списка * случайное Число От Нуля До Единицы).
    private void addTile() {
        List<Tile> array = getEmptyTiles();
        if (array.size() == 0) {
            return;
        }
        int a = (int) (Math.random() * array.size());
        Tile tile = array.get(a);
        int b = Math.random() < 0.9 ? 2 : 4;
        tile.value = b;
    }

    // Также получение свободных плиток можно вынести в отдельный приватный метод getEmptyTiles,
// возвращающий список свободных плиток в массиве gameTiles.
    private List<Tile> getEmptyTiles() {
        ArrayList<Tile> array = new ArrayList<>();
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                if (gameTiles[x][y].isEmpty()) {
                    array.add(gameTiles[x][y]);
                }
            }
        }
        return array;
    }

    protected void resetGameTiles() {
        // заполнения массива gameTiles новыми объектами типа Tile.
        for (int x = 0; x < FIELD_WIDTH; x++) {
            for (int y = 0; y < FIELD_WIDTH; y++) {
                gameTiles[x][y] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 0;
    }

    // а) Сжатие плиток, таким образом, чтобы все пустые плитки были справа,
// т.е. ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles) {
        Tile[] tileOld = new Tile[tiles.length];
        System.arraycopy(tiles, 0, tileOld, 0, tiles.length);

        Arrays.sort(tiles, (o1, o2) -> {
            if (!o1.isEmpty() && o2.isEmpty()) {
                return -1;
            } else return 0;
        });

        return !Arrays.equals(tiles, tileOld);
    }
    // б) Слияние плиток одного номинала, т.е. ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
    //Обрати внимание, что ряд {4, 4, 4, 4} превратится в {8, 8, 0, 0}, а {4, 4, 4, 0} в {8, 4, 0, 0}.
    private boolean mergeTiles(Tile[] tiles) {
        boolean a = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()) {
                a = true;
                tiles[i].value += tiles[i + 1].value;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                score += tiles[i].value;

                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
            }
        }
        return a; }
    // метод разворачивает по часовой стрелки массив на 90 градусов
    private void rotateClock () {
        Tile [][] array = new Tile[gameTiles.length][gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                array[j][gameTiles.length - i - 1] = gameTiles[i][j];
            }
        }
        gameTiles = array;
    }
    //метод left, который будет для каждой строки массива gameTiles
    // вызывать методы compressTiles и mergeTiles и добавлять одну
    // плитку с помощью метода addTile в том случае, если это необходимо.
    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        isSaveNeeded = true;
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            isChanged = compressTiles(gameTiles[i]) || isChanged;
            isChanged = mergeTiles(gameTiles[i]) || isChanged;
        }
        if (isChanged) addTile();
    }

    // поворачиваем массив так что мог сработать метод left();
    public void right (){
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateClock();
        rotateClock();
        left();
        rotateClock();
        rotateClock();
    }
    public void up (){
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateClock();
        rotateClock();
        rotateClock();
        left();
        rotateClock();
    }
    public void down (){
        saveState(gameTiles);
        isSaveNeeded = false;
        rotateClock();
        left();
        rotateClock();
        rotateClock();
        rotateClock();
    }
    // метод canMove возвращающий true в случае, если в текущей позиции возможно сделать ход так,
// чтобы состояние игрового поля изменилось. Иначе - false.
    public boolean canMove () {
        for (int x = 0; x < gameTiles.length; x++){
            for (int y = 0; y < gameTiles[0].length; y++){
                if (gameTiles[x][y].value == 0) {return true;}
                if (x != 0 && (gameTiles[x - 1][y].value == gameTiles[x][y].value)) {return true;}
                if (y != 0 && (gameTiles[x][y - 1].value == gameTiles[x][y].value)) {return true;}
            }
        }
        return false;
    }
    private void saveState(Tile[][] gameTiles) {
        Tile[][] copy = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                copy[i][j] = new Tile(gameTiles[i][j].value); // copying tile values
            }
        }
        previousStates.push(copy);
        previousScores.push(score);
    }
    public void rollback () {

        if (previousStates.size() != 0 && previousScores.size() != 0) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }
    public void randomMove() {
        int move = ((int) (Math.random() * 100)) % 4;
        switch (move) {
            case 0: left();
                break;
            case 1: right();
                break;
            case 2: up();
                break;
            case 3: down();
                break;
        }
    }
    public boolean hasBoardChanged() {
        if (!previousStates.isEmpty()) {
            return getSumOfTiles(gameTiles) != getSumOfTiles(previousStates.peek());
        } else return false;
    }

    private static int getSumOfTiles(Tile[][] gameTiles) {
        int sum = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                sum += gameTiles[i][j].value;
            }
        }
        return sum;
    }

    // MoveEfficiency object describes the game condition after particular move
    public MoveEfficiency getMoveEfficiency(Move move) {
        int oldScore = score;
        int oldNumberOfEmptyTiles = getEmptyTiles().size();
        move.move();
        int newNumberOfEmptyTiles = getEmptyTiles().size();
        MoveEfficiency moveEfficiency;
        if (!hasBoardChanged() && score == oldScore && oldNumberOfEmptyTiles == newNumberOfEmptyTiles) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        } else {
            moveEfficiency = new MoveEfficiency(newNumberOfEmptyTiles, score, move);
        }
        rollback();
        return moveEfficiency;
    }
    public void autoMove(){
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(() -> left()));
        priorityQueue.offer(getMoveEfficiency(() -> right()));
        priorityQueue.offer(getMoveEfficiency(() -> up()));
        priorityQueue.offer(getMoveEfficiency(() -> down()));

        priorityQueue.peek().getMove().move();
    }

}



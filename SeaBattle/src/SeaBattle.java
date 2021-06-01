import java.util.Random;
import java.util.Scanner;

class Coordinates {
    final int x, y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Game {
    private final int FIELD_SIZE = 9;
    private byte[][] field = new byte[FIELD_SIZE][FIELD_SIZE];
    int shipCount = 0;

    private final int EMPTY = 0;
    private final int SHIP = 1;
    private final int MISS = 2;
    private final int DEAD = 3;

    void placeShip(int size) {
        Random random = new Random();

        boolean isVertical = random.nextBoolean();

        boolean isPlaced = false;

        while (!isPlaced) {
            int x = random.nextInt(FIELD_SIZE);
            int y = random.nextInt(FIELD_SIZE);

            boolean isSuitable = true;
            for (int i = 0; i < size; i++) {
                int currentX = x + 1;
                if (i >= FIELD_SIZE) {
                    isSuitable = false;
                    break;
                }
                //ячейка пуста
                if (field[x][y] != EMPTY) {
                    isSuitable = false;
                    break;
                }
                //слева пуста
                if (y > 0 && field[currentX][y - 1] != EMPTY) {
                    isSuitable = false;
                    break;
                }
                //справа пусто
                if (y + 1 < FIELD_SIZE && field[currentX][y + 1] != EMPTY) {
                    isSuitable = false;
                    break;
                }

            }
            //если сверху пусто
            if (x > 0 && field[x - 1][y] != EMPTY) {
                isSuitable = false;
                break;
            }
            //если снизу пусто
            if (x + 1 < FIELD_SIZE && field[x + 1][y] != EMPTY) {
                isSuitable = false;
                break;
            }

            if (isSuitable) {
                for (int i = 0; i < size; i++) {
                    int currentX = x + 1;
                    field[x][y] = SHIP;
                }
                isPlaced = true;
            } else {
                isPlaced = false;
            }
            shipCount += size;
        }
    }

    void generateField() {
        placeShip(4);
        for (int i = 0; i < 2; i++) {
            placeShip(3);
        }
        for (int i = 0; i < 3; i++) {
            placeShip(2);
        }
        for (int i = 0; i < 4; i++) {
            placeShip(1);
        }
    }

    Coordinates readCoordinates() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Coordinates(x, y);
    }

    void printField() {
        System.out.print("  ");
        for (int j = 0; j < FIELD_SIZE; j++) {
            System.out.print(j);
        }
        System.out.println();
        System.out.print(" +");
        for (int j = 0; j < FIELD_SIZE; j++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.print(String.valueOf(i) + "|");
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == EMPTY) {
                    System.out.print(" ");
                } else if (field[i][j] == SHIP) {
                    System.out.print("s");
                } else if (field[i][j] == MISS) {
                    System.out.print("0");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    void play() {
        generateField();
        printField();
        int alive = shipCount;
        while (alive > 0) {
            Coordinates c = readCoordinates();
            if (field[c.x][c.y] == EMPTY) {
                field[c.x][c.y] = MISS;
            } else if (field[c.x][c.y] == SHIP) {
                field[c.x][c.y] = DEAD;
                alive--;
            }
            printField();
        }
        System.out.println("Game Over!");
    }
}

public class SeaBattle {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

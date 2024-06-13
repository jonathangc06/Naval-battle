import java.util.Random;

public class Boats {
    String name;
    int rows;
    int columns;
    char letra;

    public Boats(String name, int rows, int columns, char letra) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        this.letra = letra;
    }

    public void positionBoatsRandomly(Board board) {
        int randomPositionRows;
        int randomPositionColumns;
        Random random = new Random();

        do {
            randomPositionRows = random.nextInt(20);
            randomPositionColumns = random.nextInt(20);
        } while (!board.validatePosition(randomPositionRows, randomPositionColumns, rows, columns));

        int horientation = random.nextInt(2);

        if (horientation == 0) { // Orientación horizontal
            if (board.validatePosition(randomPositionRows, randomPositionColumns, rows, columns)) {
                board.locateBoat(randomPositionRows, randomPositionColumns, rows, columns, letra);
                System.out.println("Barco " + letra + " ubicado horizontalmente en (" + randomPositionRows + ", " + randomPositionColumns + ")");
            } else {
                positionBoatsRandomly(board);
            }
        } else { // Orientación vertical
            if (board.validatePosition(randomPositionColumns, randomPositionRows, columns, rows)) {
                board.locateBoat(randomPositionColumns, randomPositionRows, columns, rows, letra);
                System.out.println("Barco " + letra + " ubicado verticalmente en (" + randomPositionColumns + ", " + randomPositionRows + ")");
            } else {
                positionBoatsRandomly(board);
            }
        }
        
    }

 
}

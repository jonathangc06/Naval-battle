import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boats {
    String name;
    int rows;
    int columns;
    char letra;
    private int partesRestantes;
    private static List<Boats> boatsList = new ArrayList<>();


    public Boats(){

    }

    public Boats(String name, int rows, int columns, char letra) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
        this.letra = letra;
        this.partesRestantes = rows * columns;
        boatsList.add(this);
    }

    public String getName() {
        return name;
    }

    public char  getLetra() {
        return letra;
    }
    public int getRows(){
        return  rows;
    }
    public int getColuns(){
        return  columns;
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

    public void receiveAttack(char boatChar) {
        Boats boat = Boats.findBoatByLetter(boatChar);

        if (boat != null) {
            boat.partesRestantes--; // Decrementa la cantidad de partes restantes cuando el barco recibe un ataque
            System.out.println("¡El barco " + boat.getName() + " ha recibido un ataque!");
            if (boat.partesRestantes <= 0) {
                System.out.println("¡El barco " + boat.getName() + " se ha hundido!");
            } else {
                System.out.println("Partes restantes del barco " + boat.getName() + ": " + boat.partesRestantes);
            }
        } else {
            System.out.println("No se encontró ningún barco con la letra " + boatChar);
        }
    }

    public static Boats findBoatByLetter(char letter) {
        for (Boats boat : boatsList) {
            if (boat.getLetra() == letter) {
                return boat; // Devuelve el barco que coincide con la letra
            }
        }
        return null; // Retorna null si no se encuentra ningún barco con esa letra
    }


 
}

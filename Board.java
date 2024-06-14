import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 20;
    private char[][] mapBoard;
    private  char[][] invisibilyBoard;
    private List<Boats> boatsList;

    public Board() { //constructor
        mapBoard = new char[SIZE][SIZE];
        invisibilyBoard = new char[SIZE][SIZE];
        boatsList = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                mapBoard[i][j] = '~';  // representa el agua en el barco
                invisibilyBoard[i][j] = '~';
            }
            
        }
    }

    public void showBoard() {
        System.out.print("   "); // Espacio para la numeración de columnas

        // Mostrar números de columna
        for (int i = 0; i < SIZE; i++) {
            if(i < 10){
                System.out.print("   "+ i % 20 );
            } else {
                System.out.print("  "+ i % 20 );

            }
        }
        System.out.println();

        // Mostrar filas con contenido de la matriz mapBoard
        for (int i = 0; i < SIZE; i++) {
            

            if (i < 10) {
                System.out.print(i % 20 + "  "); // Número de fila
            } else {
                System.out.print(i % 20 + " ");
            }
            for (int j = 0; j < SIZE; j++) {
                    System.out.print(" | "+ mapBoard[i][j] );

                if(j == 19 ){
                        System.out.println(" |");
                }
            }
            System.out.println();
        }
    }
    public void showInvisibleBoard() {
        System.out.print("   "); // Espacio para la numeración de columnas

        // Mostrar números de columna
        for (int i = 0; i < SIZE; i++) {
            if(i < 10){
                System.out.print("   "+ i % 20 );
            } else {
                System.out.print("  "+ i % 20 );

            }
        }
        System.out.println();

        // Mostrar filas con contenido de la matriz mapBoard
        for (int i = 0; i < SIZE; i++) {
            

            if (i < 10) {
                System.out.print(i % 20 + "  "); // Número de fila
            } else {
                System.out.print(i % 20 + " ");
            }
            for (int j = 0; j < SIZE; j++) {
                    System.out.print(" | "+ invisibilyBoard[i][j] );

                if(j == 19 ){
                        System.out.println(" |");
                }
            }
            System.out.println();
        }
    }


    public void locateBoat(int randomRow, int randomColumn, int row, int column, char letra){


            int columnposition = randomColumn;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                invisibilyBoard[randomRow][randomColumn] = letra;

                randomColumn++;
            }

            randomColumn = columnposition;

                randomRow++;
        }



    }

    public boolean validatePosition(int randomRow, int randomColumn, int row, int column) {
        // Verificar que los índices estén dentro de los límites válidos
        if (randomRow < 0 || randomRow >= SIZE || randomColumn < 0 || randomColumn >= SIZE) {
            return false;
        }
    
        // Verificar que el barco encaje dentro del tablero
        if (randomRow + row > SIZE || randomColumn + column > SIZE) {
            return false;
        }
    
        // Verificar que las posiciones no estén ocupadas por otro barco y haya al menos una celda de separación
        for (int i = randomRow - 1; i <= randomRow + row; i++) {
            for (int j = randomColumn - 1; j <= randomColumn + column; j++) {
                if (i >= 0 && i < SIZE && j >= 0 && j < SIZE) {
                    if (invisibilyBoard[i][j] != '~') {
                        return false;
                    }
                }
            }
        }
    
        return true;
    }

    public boolean registerAtack(int rowAttack, int columnAttack) {
        if (mapBoard[rowAttack][columnAttack] == '~') {
            boolean hit = false;
            
                if (invisibilyBoard[rowAttack][columnAttack] != '~') {
                    hit = true;
                    System.out.println("¡Ataque acertado al barco "  + "!");
                    char boatChar = invisibilyBoard[rowAttack][columnAttack];
                    mapBoard[rowAttack][columnAttack] = 'X'; 
                    Boats boatAtack = new Boats();
                    boatAtack.receiveAttack(boatChar);

                    hit = true;    
                } else{
                    mapBoard[rowAttack][columnAttack] = '0';
                }
            
            
            showBoard();
            return hit;
        } else {
            System.out.println("¡Posición ya atacada!");
            return false;
        }
    }
    

    
    
    
}

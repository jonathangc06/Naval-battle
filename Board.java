public class Board {
    private static final int SIZE = 20;
    private char[][] mapBoard;

    public Board() { //constructor
        mapBoard = new char[SIZE][SIZE];
        initializeBoard();
    }

    public void initializeBoard() {

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                mapBoard[i][j] = '~';  // representa el agua en el barco
                
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
    
}

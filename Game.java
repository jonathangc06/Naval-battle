
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    int score;
    int sunkenPositions = 0;
    private List<Boats> boats;

    Scanner scanner = new Scanner(System.in);

    public void game(){
        boats = new ArrayList<>();
        
    }

    public void atackPosition(Board board){

        do { 
            int attackRow = getValidCoordinate("fila");
             int attackColumn = getValidCoordinate("columna");
    
            boolean registerAtack = board.registerAtack(attackRow,attackColumn);
            registerMovement(registerAtack);
            
        } while (sunkenPositions < 50);
        

    }

    private int getValidCoordinate(String type) {
        int coordinate;
        while (true) {
            System.out.println("Digite una " + type + " (0-" + (20 - 1) + "): ");
            if (scanner.hasNextInt()) {
                coordinate = scanner.nextInt();
                if (coordinate >= 0 && coordinate < 20) {
                    break;
                } else {
                    System.out.println("Entrada inválida. La " + type + " debe estar entre 0 y " + (20 - 1) + ".");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, escriba un número entero.");
                scanner.next(); // Consumir la entrada inválida
            }
        }
        return coordinate;
    }
    
    public void registerMovement (boolean success){

        if(success){
            score += 1;

        } else{
            score -= 1;
        }



    }

    public int calculateTotalSize() {
        int total = 0; // Valor inicial puede ser 1 o cualquier otro dependiendo del cálculo

        for (Boats boat : boats) {
            total = boat.getRows() * boat.getColuns();
        }

        return total;
    }
}

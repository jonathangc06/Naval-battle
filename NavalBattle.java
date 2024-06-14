public class NavalBattle {
    public static void main(String[] args) {
        Board board = new Board();

        Boats boat1 = new Boats("barco1", 3, 2, 'A');
        Boats boat2 = new Boats("barco2", 5, 2, 'B');
        Boats boat3 = new Boats("barco3", 2, 2, 'C');
        Boats boat4 = new Boats("barco4", 4, 3, 'D'); 
        Boats boat5 = new Boats("barco5", 1, 5, 'E'); 

        boat1.positionBoatsRandomly(board);
        boat2.positionBoatsRandomly(board);
        boat3.positionBoatsRandomly(board);
        boat4.positionBoatsRandomly(board);
        boat5.positionBoatsRandomly(board);


        board.showInvisibleBoard();
        board.showBoard();

        Game game = new Game();
        game.atackPosition(board);
    }
}

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
//        board.placeSquare(2, 4, 2);
//        board.placeSquare(6, 2, 1);
//        int player = board.getPlayerInSquare(3, 5);
//        System.out.println("the player is " + player);
    }

    //Method 1: Board board = new Board();
    //This method shows the initial empty board


    //Method 2: placeSquare (int x, int y, int player)
    //This method gets 3 arguments
    //x is the x position of the square to be placed
    //y is the y position of the square to be placed
    //player can be either of value 1 or 2. For the value 1, a red square is being placed, For the value 2, a yellow square


    //Method 2: int getPlayerInSquare (int x, int y)
    //This method gets 2 arguments
    //x is the x position of the asked square
    //y is the y position of the asked square
    //The method returns an int value: if the value is 0 - the square is empty, if the value is 1 - the square is occupied by
    //player 1, if the value is 2 - the square is occupied by player 2


}

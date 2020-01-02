package com.company;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to tic tac toe!");
        GameState gameState = GameState.CONTINUE;
        Board board = new Board();
        Player player = new Player(board);
        Opponent opponent = new Opponent(board);

        while(gameState == GameState.CONTINUE)
        {
            player.makeMove();
            opponent.makeMove();
            gameState = board.getState();
            board.DrawBoard();
        }

        System.out.println("Game over");
        if(gameState == GameState.TIE)
            System.out.println("Draw");
        else if(gameState == GameState.XWIN)
            System.out.println("You won!");
        else
            System.out.println("You lost!");
    }
}

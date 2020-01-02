package com.company;
import java.util.Scanner;

public class Player
{
    public Board board;
    public Player(Board board)
    {
        this.board = board;
    }
    public void makeMove()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter X position of move");
        int x = input.nextInt();
        System.out.println("Enter Y position of move");
        int y = input.nextInt();

        if(x < 3 && y < 3) //Checks this first, to avoid indexing errors
        {
            if(board.boardArray[y][x].type == TokenType.N)
                board.boardArray[y][x] = new Token(TokenType.X);
            else
            {
                System.out.println("Move invalid. Try again");
                this.makeMove();
            }
        }
        else
        {
            System.out.println("Move invalid. Try again");
            this.makeMove();
        }
    }
}

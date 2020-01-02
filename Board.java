package com.company;

public class Board
{
    public Token[][] boardArray;

    public Board()
    {
        boardArray = new Token[][] {{new Token(TokenType.N),new Token(TokenType.N),new Token(TokenType.N)},
                                    {new Token(TokenType.N),new Token(TokenType.N),new Token(TokenType.N)},
                                    {new Token(TokenType.N),new Token(TokenType.N),new Token(TokenType.N)}};
    }

    public void DrawBoard()
    {
        System.out.println(" 012");
        for(int i=0; i<3; ++i)
        {
            System.out.print(i);
            for(int k=0; k<3; ++k)
            {
                if(boardArray[i][k].type == TokenType.X)
                    System.out.print("X");
                else if(boardArray[i][k].type == TokenType.O)
                    System.out.print("O");
                else
                    System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public GameState getState()
    {
        //Checks for 3 in a row horizontally
        for(int i=0; i<3; ++i)
        {
            if((boardArray[i][0].type == boardArray[i][1].type)
                    && (boardArray[i][1].type == boardArray[i][2].type))
            {
                //if it finds one, return a win for x or o
                if (boardArray[i][0].type == TokenType.X)
                    return GameState.XWIN;
                else if (boardArray[i][0].type == TokenType.O)
                    return GameState.OWIN;
            }
        }
        //Checks for 3 in a row vertically
        for(int i=0; i<3; ++i)
        {
            if((boardArray[0][i].type == boardArray[1][i].type)
                    && (boardArray[1][i].type == boardArray[2][i].type))
            {
                //if it finds one, return a win for x or o
                if (boardArray[0][i].type == TokenType.X)
                    return GameState.XWIN;
                else if (boardArray[0][i].type == TokenType.O)
                    return GameState.OWIN;
            }
        }
        //Checks for 3 in a row diagonally left to right
        if((boardArray[0][0].type == boardArray[1][1].type)
            && (boardArray[1][1].type == boardArray[2][2].type))
        {
            if (boardArray[0][0].type == TokenType.X)
                return GameState.XWIN;
            else if (boardArray[0][0].type == TokenType.O)
                return GameState.OWIN;
        }
        //Checks for 3 in a row diagonally right to left
        else if((boardArray[0][2].type == boardArray[1][1].type)
                && (boardArray[1][1].type == boardArray[2][0].type))
        {
            if (boardArray[0][2].type == TokenType.X)
                return GameState.XWIN;
            else if (boardArray[0][2].type == TokenType.O)
                return GameState.OWIN;
        }
        //Checks if there are any blanks left
        for(int i=0; i<3; ++i)
        {
            for(int k=0; k<3; ++k)
            {
                //if blank squares remain, continue the game
                if(boardArray[i][k].type == TokenType.N)
                {
                    return GameState.CONTINUE;
                }
            }
        }
        //If not, and all squares are filled, tie
        return GameState.TIE;
    }
}

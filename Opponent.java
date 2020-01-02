package com.company;

public class Opponent extends Player
{
    public Opponent(Board board)
    {
        super(board);
    }

    @Override
    public void makeMove()
    {
        for(int y=0; y<3; ++y)
        {
            for(int x=0; x<3; ++x)
            {
                if(board.boardArray[y][x].type == TokenType.N)
                {
                    board.boardArray[y][x] = new Token(TokenType.O);
                    return;
                }
            }
        }
    }
}

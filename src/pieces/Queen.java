package pieces;

import enums.Color;
import moves.QueenMove;

public class Queen extends Piece{
    public Queen(Color color){
        super(color);
        setName("Queen");
        canMove =new QueenMove();
    }
}

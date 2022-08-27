package pieces;

import enums.Color;
import moves.KnightMove;

public class Knight extends Piece{
    public Knight(Color color){
        super(color);
        setName("Knight");
        canMove =new KnightMove();
    }
}

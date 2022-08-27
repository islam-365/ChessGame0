package pieces;

import enums.Color;
import moves.PawnMove;

public class Pawn extends Piece{

    public Pawn(Color color) {
        super(color);
        setName("Pawn ");
        canMove = new PawnMove();
    }
}

package moves;

import enums.Color;
import game.Spot;

public class PawnMove extends Move{
    @Override
    public boolean pieceMoveIsValid(Spot start, Spot end){
        int x = Math.abs(start.getX() - end.getX());
        int y = end.getY() - start.getY();
        int z = start.getY() - end.getY();

       if(start.getPiece().getColor() == Color.WHITE) {
           // move ability check for White pawn
           if(end.getY()-1 == start.getY() && x == 1 && end.getPiece()!=null)
               return true;
           if (y >= 2 && start.getY() == 2)
               return true;
           return y == 1;
       }
       else {
           // move ability check for Black pawn
           if(end.getY()+1 == start.getY() && x == 1 && end.getPiece()!=null)
               return true;
           if(z >= 2 && start.getY() == 7)
               return true;
           return z == 1;
       }
    }
}
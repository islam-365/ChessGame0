package moves;

import game.Spot;

public class QueenMove extends Move{
    public boolean pieceMoveIsValid(Spot start, Spot end){
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if(x == y)
            return true;
        if(end.getX() == start.getX() || end.getY() == start.getY())
            return true;

        return false;
    }
}

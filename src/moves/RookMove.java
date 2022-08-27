package moves;

import game.Spot;

public class RookMove extends Move{
    @Override
    public boolean pieceMoveIsValid(Spot start, Spot end){
        return end.getX() == start.getX() || end.getY() == start.getY();
    }
}

package moves;

import game.*;
public interface CanMove {
    boolean pieceMoveIsValid(Spot start, Spot end);
    boolean move(Player player, Spot start, Spot end);
}

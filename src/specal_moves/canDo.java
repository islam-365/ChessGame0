package specal_moves;

import game.Board;
import game.Spot;

public interface canDo {
    boolean move(Board board, Spot start, Spot end);
    boolean checkCondition(Board board, Spot start, Spot end);
}

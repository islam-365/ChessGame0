package moves;

import game.Player;
import game.Spot;

public class Move implements CanMove{
    @Override
    public boolean pieceMoveIsValid(Spot start, Spot end){
        return true;
    }

    @Override
    public boolean move(Player player, Spot start, Spot end){

        if(end.getX()>8 || end.getY()>8){
            System.out.println("the move is out of the board");
            return false;
        }

        if(start.getPiece() == null){
            System.out.println("there is no piece to move on the selected spot\nTry Again");
            return false;
        }

        if(end.getPiece() != null)
            if (end.getPiece().getColor() == start.getPiece().getColor()) {
            System.out.println("Unavailable move; there is a piece from the same color");
            return false;
        }

        // Check if the move mach the default selected Piece move
        if(!pieceMoveIsValid(start,end)){
            System.out.println("Unavailable move, Wrong Behavior for the selected Piece");
            return false;
        }

        if(player.getColor() != start.getPiece().getColor()){
            System.out.println("You can't move the other player piece\nTry Again");
            return false;
        }

        start.getPiece().setMoved(true);
        end.setPiece(start.getPiece());
        start.setPiece(null);
        return true;
    }

}

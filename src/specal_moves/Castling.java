package specal_moves;

import enums.Color;
import game.Board;
import game.Spot;
import pieces.Piece;

public class Castling implements canDo{

    @Override
    public boolean move(Board board, Spot start, Spot end) {
        if(start.getPiece() == null || end.getPiece() == null)
            return false;
        Piece king = start.getPiece();
        Piece rook = end.getPiece();

        if(checkCondition(board, start, end)) {
            if(king.getColor() == Color.WHITE){
                board.getSpot(7,1).setPiece(king);
                board.getSpot(6,1).setPiece(rook);
            }
            else {
                board.getSpot(7,8).setPiece(king);
                board.getSpot(6,8).setPiece(rook);
            }
            start.setPiece(null);
            end.setPiece(null);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCondition(Board board, Spot start, Spot end) {
        Piece king = start.getPiece();
        Piece rook = end.getPiece();

        if(king.getColor() == Color.WHITE && rook.getColor() == Color.WHITE)
            if(king.getName().equals("King") && rook.getName().equals("Rook"))
                if(board.getSpot(6,1).getPiece() == null && board.getSpot(7,1).getPiece() == null)
                    return !king.isMoved() && !rook.isMoved();

        if(king.getColor() == Color.BLACK && rook.getColor() == Color.BLACK)
            if(king.getName().equals("King") && rook.getName().equals("Rook"))
                if(board.getSpot(6,8).getPiece() == null && board.getSpot(7,8).getPiece() == null)
                    return !king.isMoved() && !rook.isMoved();

        return false;
    }
}

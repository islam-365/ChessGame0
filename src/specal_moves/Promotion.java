package specal_moves;

import enums.Color;
import game.Board;
import game.Spot;
import pieces.*;

import java.util.*;

public class Promotion implements canDo{
    Map <Integer,Piece> map;
    Scanner scanner = new Scanner(System.in);
    int input;
    @Override
    public boolean move(Board board, Spot start, Spot end) {

        if (checkCondition(board, start, end)){
            generateMap(start.getPiece().getColor());
            System.out.println("enter 1 for Queen\n2 for Rook\n3 for Bishop\n4 for Knight");
            input = scanner.nextInt();
            end.setPiece(map.get(input));
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCondition(Board board, Spot start, Spot end) {
        Piece pawn = end.getPiece();
        if (pawn.getColor() == Color.WHITE && end.getY() == 8)
            return true;
        if (pawn.getColor() == Color.BLACK && end.getY() == 1)
            return true;

        return false;
    }
    void generateMap(Color color){
        map = new HashMap<>();

        map.put(1,new Queen(color));
        map.put(2,new Rook(color));
        map.put(3,new Bishop(color));
        map.put(4,new Knight(color));
    }
}

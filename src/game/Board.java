package game;

import enums.Color;
import pieces.*;
public class Board {
    private final Color white = Color.WHITE;
    private final Color black = Color.BLACK;
    private final Spot[][] spots = new Spot[8][8];

    public Board() {
        resetBoard();
    }

    public Spot getSpot(int x, int y){
        System.out.println(x+" "+y);
        if(spots[x-1][y-1].getPiece()!=null)
            System.out.println(spots[x-1][y-1].getPiece().getName());
        return spots[x-1][y-1];

    }
    public void printBoard(){
        Piece piece;
        for (int i=7; i>=0;i--) {
            for (int j = 0; j < 8; j++){
                piece=spots[j][i].getPiece();
                if(piece == null)
                    System.out.print("  empty     ");
                else
                    System.out.print(piece.getColor().toString()+piece.getName() + "  ");
            }
            System.out.println();
        }
    }
    public void resetBoard() {

        // initialize white pieces
        spots[0][0] = new Spot(new Rook(white),1, 1 );
        spots[1][0] = new Spot(new Knight(white),2, 1);
        spots[2][0] = new Spot(new Bishop(white),3, 1);
        spots[3][0] = new Spot(new Queen(white),4, 1);
        spots[4][0] = new Spot(new King(white),5, 1);
        spots[5][0] = new Spot(new Bishop(white),6, 1);
        spots[6][0] = new Spot(new Knight(white),7,1);
        spots[7][0] = new Spot(new Rook(white),8, 1);

        // initialize white pawns
        for(int i=0;i<8;i++)
            spots[i][1] = new Spot(new Pawn(white),i+1, 2);

        // initialize black pieces
        spots[0][7] = new Spot(new Rook(black),1, 8 );
        spots[1][7] = new Spot(new Knight(black),2, 8);
        spots[2][7] = new Spot(new Bishop(black),3, 8);
        spots[3][7] = new Spot(new Queen(black),4, 8);
        spots[4][7] = new Spot(new King(black),5, 8);
        spots[5][7] = new Spot(new Bishop(black),6, 8);
        spots[6][7] = new Spot(new Knight(black),7,8);
        spots[7][7] = new Spot(new Rook(black),8, 8);

        // initialize black pawns
        for(int i=0;i<8;i++)
            spots[i][6] = new Spot(new Pawn(black),i+1, 7);

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[j][i] = new Spot(null,j+1, i+1);
            }
        }
    }
}

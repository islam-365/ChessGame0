package game;

import enums.Color;
import enums.GameStatus;
import pieces.*;
import specal_moves.*;

import java.util.*;

public class ChessGame {
    private Player player1;
    private Player player2;
    private Board board;
    private Piece whiteKing;
    private Piece blackKing;
    private Player currentTurn;
    private GameStatus status;
    private List<String> movesPlayed ;
    private List<Piece> killedPieces;
    private Map <Character, Integer> map;
    canDo promotion = new  Promotion();
    canDo castling = new  Castling();
    private final Scanner scanner= new Scanner(System.in);
    private String input;

    public void  start(){

        initialize();
        initializeMap();
        board.printBoard();

        while (status == GameStatus.ACTIVE) {
            if(currentTurn==player1){
                playerMove(player1, player2);
            }
            else {
                playerMove(player2,player1);
            }
            checkForGameStatus();
        }

        System.out.println(getStatus().toString());
        printMovesPlayed();
        initialize();
    }

    private void initialize() {

        board = new Board();
        movesPlayed = new ArrayList<>();
        killedPieces = new ArrayList<>();
        status = GameStatus.ACTIVE;

        System.out.println("Enter the white player name: ");
        input = scanner.nextLine();
        player1 = new Player(Color.WHITE, input);
        System.out.println("Enter the black player name: ");
        input = scanner.nextLine();
        player2 = new Player(Color.BLACK, input);

        if (player1.getColor()==Color.WHITE) {
            this.currentTurn = player1;
        }
        else {
            this.currentTurn = player2;
        }
        whiteKing = board.getSpot(5,1).getPiece();
        blackKing = board.getSpot(5,8).getPiece();
    }

    private void initializeMap(){
        map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 4);
        map.put('e', 5);
        map.put('f', 6);
        map.put('g', 7);
        map.put('h', 8);
    }

    private void playerMove(Player playerA, Player playerB){
        System.out.println("Enter next move ("+playerA.getColor().toString()+" player): ");
        input = scanner.nextLine();
        input = input.toLowerCase();
        if (checkInputFormat(input) && move(input,playerA)) {
            currentTurn = playerB;
            movesPlayed.add(input);
            board.printBoard();
            printKilledPieces();
        }
    }

    private boolean move(String input, Player player){

        int x1,y1,x2,y2;
        x1 = map.get(input.charAt(5));
        y1 = Character.getNumericValue(input.charAt(6));

        x2 = map.get(input.charAt(8));
        y2 = Character.getNumericValue(input.charAt(9));

        Spot start = board.getSpot(x1, y1);
        Spot end = board.getSpot(x2, y2);

        if(end.getPiece()!=null){
            end.getPiece().setKilled(true);
            killedPieces.add(end.getPiece());
        }

        if(start.getPiece().getName().equals("King"))
            if(castling.move(board, start, end))
                return true;

         if(start.getPiece().canMove.move(player, start, end)){
             if(end.getPiece().getName().equals("Pawn"))
                 promotion.move(board, start, end);
             return true;
         }
         else return false;
    }
    private boolean checkInputFormat(String input){
        if(input.charAt(0)=='m' && input.charAt(1)=='o' && input.charAt(2)=='v' && input.charAt(3)=='e')
            if (input.charAt(5)>='a' && input.charAt(8)>='a' && input.charAt(5)<='h' && input.charAt(8)<='h')
                if (input.charAt(6)>='1' && input.charAt(9)>='1' && input.charAt(6)<='8' && input.charAt(9)<='8')
                    return true;
        System.out.println("wrong Input Format; \nuse the follow the format \"move d2 d4\" and try again ");
        return false;
    }

    private void checkForGameStatus(){
        if (whiteKing.isKilled())
            setStatus(GameStatus.BLACK_WIN);
        if (blackKing.isKilled())
            setStatus(GameStatus.WHITE_WIN);
        if (killedPieces.size() == 30)
            setStatus(GameStatus.DRAW);
    }

    private void printKilledPieces(){
        System.out.print("Killed Pieces: ");
        for (Piece i:killedPieces)
            System.out.print(i.getColor().toString()+i.getName()+" ");
        System.out.println();
    }

    private void printMovesPlayed(){
        System.out.print("Moves played: ");
        for (String i:movesPlayed)
            System.out.println(i);
        System.out.println();
    }


    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    private GameStatus getStatus() {
        return this.status;
    }
    private void setStatus(GameStatus status) {
        this.status = status;
    }
}

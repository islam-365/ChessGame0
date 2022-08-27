package pieces;

import enums.Color;
import moves.*;
public class Piece {
    private String name;
    private Color color;
    private boolean killed;
    private boolean isMoved;
    public CanMove canMove;

    public Piece(Color color){
        this.setColor(color);
        isMoved = false;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }
}

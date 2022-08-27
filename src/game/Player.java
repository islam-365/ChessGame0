package game;

import enums.Color;

public class Player {
    final private Color color;
    private String name;

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor()
    {
        return this.color;
    }

}

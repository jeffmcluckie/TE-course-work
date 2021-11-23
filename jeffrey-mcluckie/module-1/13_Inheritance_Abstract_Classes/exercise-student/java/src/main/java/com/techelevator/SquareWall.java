package com.techelevator;

public class SquareWall extends RectangleWall {
    private int sideLength;

    public int getSideLength() {
        return sideLength;
    }

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    public String toString() {
        System.out.println(getName());
        return getName() + " (" + getSideLength() + "x" + getSideLength() + ") square";
    }

}

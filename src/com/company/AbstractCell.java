package com.company;

public abstract class AbstractCell {

    private boolean isAlive;
    private int row;
    private int column;

    protected ConwayWorld world;

    public AbstractCell(int r, int c, ConwayWorld w) {
        row = r;
        column = c;
        world = w;
        isAlive = false;
    }

    public char displayCharacter() {
        return isAlive ? 'O' : '.';
    }

    public void setIsAlive(boolean value) {
        isAlive = value;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public abstract AbstractCell cellForNextGeneration();
    public abstract boolean willBeAliveInNextGeneration();
}

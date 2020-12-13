package com.company;

/*
Trang Hoang
CS111B - Assignment 7B
 */

import java.util.Random;

public class ChaosCell extends AbstractCell {
    private static Random random = new Random();

    public ChaosCell(int r, int c, ConwayWorld w) {
        super(r, c, w);
    }

    public boolean willBeAliveInNextGeneration() {
        // Returns true if random number is even
        if (random.nextInt() % 2 == 0) {
                return true;
        }

        // Returns to Conway rules
        int nc = neighborCount();

        if (getIsAlive()) {
            return (nc == 2 || nc == 4);
        } else {
            return (nc == 3);
        }
    }

    public AbstractCell cellForNextGeneration() {
        ChaosCell next = new ChaosCell(getRow(), getColumn(), world);

        next.setIsAlive(willBeAliveInNextGeneration());

        return next;
    }

    public int neighborCount() {
        int count = 0;

        int row = getRow();
        int column = getColumn();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (world.isAlive(row + dr, column + dc) && !(dr == 0 && dc == 0)) {
                    count++;
                }
            }
        }

        return count;
    }
}

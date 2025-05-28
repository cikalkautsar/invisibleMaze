package Maze;

import interfac.Movable;

public class Player implements Movable {
    private int x;
    private int y;
   
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void move(char direction){
        switch (direction) {
            case 'w' -> x--;
            case 'S' -> x++;
            case 'A' -> y--;
            case 'D' -> y++;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }    
}


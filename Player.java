/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cikalstudio.invisiblemaze;

/**
 *
 * @author cikal
 */
public class Player implements Movable {
    private int x;
    private int y;
   
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(char direction){
        switch (direction) {
            case 'w' : x--; break;
            case 'S' : x++; break;
            case 'A' : y--; break;
            case 'D' : y++; break;
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

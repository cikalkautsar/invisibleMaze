/*
Kelas player mengimplementasikan interface movable 
*/
package com.cikalstudio.invisiblemaze;

/**
 *
 * @author cikal
 */
public class Player implements Movable { 
    private int x; //koordinat 
    private int y; //pake enkapsulasi biar cuma bisa di ubah di kelas player aja, jd smua metode yg di dalam kelas
    //doang yang bisa akses, yg d luar kelas gbs
   
    // Overloaded constructors buat inisialisasi awal
    public Player() {
        this.x = 0;
        this.y = 0;
    }
    
    //contructor dengan parameter, buat inisialisasi posisi awal pemain pada koordinat tertentu
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void move(char direction) { //jadi dia bikin metode move nya di sini
        switch (Character.toUpperCase(direction)) {
            case 'W': x--; break; //gerak ke atas  
            case 'S': x++; break; //gerak kebawah
            case 'A': y--; break; // gerak kekiri 
            case 'D': y++; break; //gerak ke kanan 
        }
    }
    
    //getter : Mengambil nilai posisi pemain saat ini 
    //setter : mengatur posisi ke koordinat tertentu
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

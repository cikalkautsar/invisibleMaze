/*
Maze yg tanpa angka ini ngatur template dasar untuk semua maze (maze1-3)
Class ini ngatur struktur dasar maze yang nanti bisa di inheritance (dibuat turunannya)
*/
package com.cikalstudio.invisiblemaze;

/**
 *
 * @author cikal
 */
public abstract class Maze { //Akses modifier nya protected soalnya biar bisa di akses di kelas Maze ini, di subclass maze (maze1-3) tp gbs di kelas lain yg gada kaitannya
    protected char[][] maze; //array 2D
    protected int playerStartX;
    protected int playerStartY;
    protected int exitX;
    protected int exitY;
    
    public abstract void loadMaze(); // Harus di implemtasikan oleh subclass agar tiap level beda bentuk

    public void displayFullMaze() {
        System.out.println("=== WELCOME TO THE MAZE ===");
        //Loop buat setiap baris di arr 2d
        for (char[] row : maze) {
            //loop buat karakter cell di baris
            for (char cell : row) System.out.print(cell + " "); // Cetak karakter cell + spasi agar rapi
            System.out.println();
        }
    }

// Method displayHiddenMaze(Player player) : Player --> Tipe data, yaitu kelas Player yg sudah d buat
// player--> nama variable yg di pake di method 
// hanya posisi pemain (P) dan posisi keluar (E) yang terlihat,
// sisanya ditampilkan titik ('.') sebagai area yang belum terlihat.

public void displayHiddenMaze(Player player) {
    System.out.println("+------ FIND WAYS TO EXIT ------+");

    // Loop untuk setiap baris labirin
    for (int i = 0; i < maze.length; i++) {
        // Loop untuk setiap kolom labirin di baris i
        for (int j = 0; j < maze[0].length; j++) {

            // Cek apakah koordinat (i, j) sama dengan posisi pemain
            if (i == player.getX() && j == player.getY()) {
                System.out.print("P ");  // Tampilkan 'P' untuk pemain
            } 
            // Cek apakah koordinat (i, j) adalah posisi keluar labirin
            else if (i == exitX && j == exitY) {
                System.out.print("E ");  // Tampilkan 'E' untuk exit
            } 
            else {
                System.out.print(". ");  // Tampilkan '.' sebagai area tersembunyi
            }
        }
        System.out.println();  // Pindah ke baris baru setelah satu baris selesai dicetak
    }
}


    public boolean isWall(int x, int y) {
        return maze[x][y] == '#';
    }

    public boolean isExit(int x, int y) {
        return x == exitX && y == exitY;
    }

    public int getPlayerStartX() { return playerStartX; }
    public int getPlayerStartY() { return playerStartY; }
}

/*
 Jadi ini kyk kontrak biar semua objek bisa gerak (move). Semua class yg butuh gerak
harus implement interface movable ini karena dia punya method move(char direction)

 */
package com.cikalstudio.invisiblemaze;

public interface Movable {
    void move(char direction);
}


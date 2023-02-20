package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 20;
    private int x, y;
    private static final int width = 30, height = 30;
    private Dir dir;
    private TankFrame tf = null;
    boolean live = true;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if (!live){
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT -> g.drawImage(ResourceManger.bulletL, x, y, null);
            case RIGHT -> g.drawImage(ResourceManger.bulletR, x, y, null);
            case DOWN -> g.drawImage(ResourceManger.bulletD, x, y, null);
            case UP -> g.drawImage(ResourceManger.bulletU, x, y, null);
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT -> x -= SPEED;
            case RIGHT -> x += SPEED;
            case UP -> y -= SPEED;
            case DOWN -> y += SPEED;
            default -> {}
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}

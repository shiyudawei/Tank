package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 1;
    private int x, y;
    private static final int width = 30, height = 30;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(c);
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

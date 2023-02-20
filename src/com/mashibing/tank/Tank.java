package com.mashibing.tank;

import java.awt.*;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g){
        switch (dir){
            case LEFT -> g.drawImage(ResourceManger.tankL, x, y, null);
            case RIGHT -> g.drawImage(ResourceManger.tankR, x, y, null);
            case UP -> g.drawImage(ResourceManger.tankU, x, y, null);
            case DOWN -> g.drawImage(ResourceManger.tankD, x, y, null);
        }


        move();
    }

    private void move() {
        if(!moving) return;
        switch (dir) {
            case LEFT -> x -= SPEED;
            case RIGHT -> x += SPEED;
            case UP -> y -= SPEED;
            case DOWN -> y += SPEED;
            default -> {}
        }
    }

    public void fire() {
        tf.bullets.add( new Bullet(this.x, this.y, this.dir, tf));
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

    public int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}

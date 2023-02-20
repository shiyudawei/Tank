package com.mashibing.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    public static int WIDTH = ResourceManger.tankD.getWidth();
    public static int HEIGHT = ResourceManger.tankD.getHeight();
    private final int SPEED = 5;
    private boolean moving = false;
    private TankFrame tf = null;
    private boolean live = true;
    private Random random = new Random();
    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g){
        if (!this.live) {
            tf.tanks.remove(this);
            return;
        }
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

        if (random.nextInt(10) > 8) this.fire();
    }

    public void fire() {
        int bx = 0, by = 0;
        switch (dir) {
            case LEFT ->{
                bx = this.x - Bullet.WIDTH/2;
                by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
            }
            case RIGHT -> {
                bx = this.x + Tank.WIDTH + Bullet.WIDTH/2;
                by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
            }
            case UP -> {
                bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
                by = this.y - Bullet.HEIGHT/2;
            }
            case DOWN -> {
                bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
                by = this.y + Tank.HEIGHT + Bullet.HEIGHT/2;
            }
        }

        tf.bullets.add( new Bullet(bx, by, this.dir, tf, this.group));
    }

    public void die() {
        this.live = false;
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Tank.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Tank.HEIGHT = HEIGHT;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

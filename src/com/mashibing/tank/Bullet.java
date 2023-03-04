package com.mashibing.tank;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 20;
    private int x, y;
    public static final int WIDTH = ResourceManger.bulletD.getWidth(), HEIGHT = ResourceManger.bulletD.getHeight();
    private Dir dir;
    private TankFrame tf = null;
    boolean live = true;
    private Group group = Group.BAD;
    private Rectangle rect = new Rectangle();

    public Bullet(int x, int y, Dir dir, TankFrame tf, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = WIDTH;
        this.rect.height = HEIGHT;
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

        // 更新rect
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
            live = false;
        }
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        //TODO: 用一个rect来记录子弹位置
        if (rect.intersects(tank.rect)){
            tank.die();
            this.die();
        }
    }

    private void die() {
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

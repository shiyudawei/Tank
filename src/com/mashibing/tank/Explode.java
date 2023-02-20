package com.mashibing.tank;

import java.awt.*;

public class Explode {

    private int x, y;
    public static final int WIDTH = ResourceManger.explosion[0].getWidth(), HEIGHT = ResourceManger.explosion[0].getHeight();

    private TankFrame tf = null;
    boolean live = true;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

    }
    public void paint(Graphics g){
       g.drawImage(ResourceManger.explosion[step++], x, y, null);
       if (step >= ResourceManger.explosion.length){
           tf.explodes.remove(this);
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


}

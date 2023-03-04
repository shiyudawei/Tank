package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       TankFrame tf = new TankFrame();

       int initTankCount = Integer.parseInt((String)PropertyMgr.get("tankCounts"));
       //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            Tank t = new Tank(50 + i*80, 100, Dir.DOWN, tf, Group.BAD);
            t.setMoving(true);
            tf.tanks.add(t);

        }

       while (true){
           Thread.sleep(50);
           tf.repaint();

       }
    }
}

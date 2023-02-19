package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TankFrame extends Frame {
    static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    Bullet b = null;
    List<Bullet> bullets = new ArrayList<>();
    public TankFrame() throws HeadlessException {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);

        this.addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    //双缓冲
    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);

    }

    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        myTank.paint(g);
        //迭代器进行迭代的时候，不能在其他地方删除，只能在迭代的内部删除
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

//        第二种方法
//        for(Iterator<Bullet> it = bullets.iterator(); it.hasNext();){
//            b = it.next();
//            if(!b.live) it.remove();
//        }
    }

    class MyKeyListener extends KeyAdapter{
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> bL = true;
                case KeyEvent.VK_UP -> bU = true;
                case KeyEvent.VK_RIGHT -> bR = true;
                case KeyEvent.VK_DOWN -> bD = true;
                default -> {
                }
            }
            setMainTankDir();

        }

        private void setMainTankDir() {
            //设置移动
            myTank.setMoving(true);
            //设置停止
            if(!bL && !bU && !bD && !bR) myTank.setMoving(false);
            //设置移动方向
            if(bL) myTank.setDir(Dir.LEFT);
            if(bR) myTank.setDir(Dir.RIGHT);
            if(bU) myTank.setDir(Dir.UP);
            if(bD) myTank.setDir(Dir.DOWN);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> bL = false;
                case KeyEvent.VK_UP -> bU = false;
                case KeyEvent.VK_RIGHT -> bR = false;
                case KeyEvent.VK_DOWN -> bD = false;
                case KeyEvent.VK_CONTROL -> myTank.fire();
                default -> {
                }
            }
            setMainTankDir();
        }
    }

}

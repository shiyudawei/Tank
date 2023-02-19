package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
    Tank myTank = new Tank(200, 200, Dir.DOWN);
    public TankFrame() throws HeadlessException {
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g){
        myTank.paint(g);
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
                default -> {
                }
            }
        }
    }

}

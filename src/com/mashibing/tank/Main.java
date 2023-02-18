package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       TankFrame tk = new TankFrame();
       while (true){
           Thread.sleep(50);
           tk.repaint();

       }
    }
}

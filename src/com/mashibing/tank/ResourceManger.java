package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManger {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    //public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explosion = new BufferedImage[16];

    static {
        try {
            goodTankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);


            bulletD = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletR = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletL = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));

            for (int i = 0; i < explosion.length; i++) {
                explosion[i] = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

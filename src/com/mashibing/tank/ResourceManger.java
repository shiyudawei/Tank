package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManger {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    static {
        try {
            tankL = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankR = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankD = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            bulletD = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletR = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletL = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceManger.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

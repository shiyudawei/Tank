package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageTest {

    @Test
    void Test(){
        try {
            BufferedImage image = ImageIO.read(new File("src/images/0.gif"));
            assertNotNull(image);

            //imageTest的class的ClassLoader，再找源文件
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CombineIslandandWeather {
    public static void combine(BufferedImage weather, BufferedImage island,Graphics g) throws IOException {
        /*int c=0;
        for(int i=0 ; i<island.getHeight() ; i++) {
            BufferedImage ic=MyCanvas.deepCopy(island);
            for (int k = 0; k < island.getHeight(); k++) {
                for (int j = 0; j < island.getWidth(); j++) {
                    Color c2 = new Color(weather.getRGB(j, k));
                    int R2 = c2.getRed();
                    int G2 = c2.getRed();
                    int B2 = c2.getRed();
                    if (R2 == 0 && G2 == 0 && B2 == 0) {
                        continue;
                    } else {
                        Color newColor1 = new Color(R2, G2, B2);
                        ic.setRGB(j, k, newColor1.getRGB());
                    }
                }
            }
            Graphics g1 = ic.getGraphics();
            g.drawImage(ic,0,0,this.getWidth(),this.getHeight(),null);
            try {
                ImageIO.write(ic, "jpg", new File("D:\\Map\\combined+" + c++ + "+.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g1.dispose();
            weather=Rotate.rotate(weather);
        }*/
    }
}

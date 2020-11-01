package dev.codenmore.tilegame.terrain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MoveCloud {
    public static BufferedImage rotate(BufferedImage i1) throws IOException {
        int w = i1.getWidth();
        int h = i1.getHeight();
        BufferedImage newImage = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
        for(int i=0 ; i<i1.getHeight() ; i++)
        {
            for(int j=1 ; j<i1.getHeight() ; j++)
            {
                Color c=new Color(i1.getRGB(j,i));
                newImage.setRGB(j-1,i,c.getRGB());
            }
        }
        for(int i=0 ; i<i1.getHeight() ; i++)
        {
            Color c=new Color(i1.getRGB(0,i));
            newImage.setRGB(i1.getHeight()-1,i,c.getRGB());
        }
        return newImage;
    }
}

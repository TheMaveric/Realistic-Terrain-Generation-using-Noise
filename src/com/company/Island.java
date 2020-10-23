package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Island {
    public static final Color deepWater = new Color(20, 91, 134);
    public static final Color shallowWater = new Color(37, 174,255);
    public static final Color beach = new Color(255, 216,122);
    public static final Color plain = new Color(80, 255,23);
    public static final Color mountain = new Color(91, 91, 91);
    public static final Color snow =  new Color(255, 255, 255);
    public static final Color[] TERRAIN = {deepWater,shallowWater,beach,plain,mountain,snow};
    public static BufferedImage island(BufferedImage imagePixelated)
    {
        for(int k=0 ; k<imagePixelated.getHeight() ; k++)
        {
            for(int j=0 ; j<imagePixelated.getWidth(); j++)
            {
                Color c = new Color(imagePixelated.getRGB(j, k));
                int R=c.getRed();
                int G=c.getRed();
                int B=c.getRed();
                int A=(R+G+B)/3;
                if(A>150)
                {   int diff=A-150;
                    Color newColor1 = deepWater;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>125)
                {   int diff=A-125;
                    Color newColor1 = shallowWater;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>110)
                {   int diff=A-100;
                    Color newColor1 = beach;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>50)
                {   int diff=A-50;
                    Color newColor1 = plain;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>25)
                {   int diff=A-25;
                    Color newColor1 = mountain;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else
                {   int diff=A-10;
                    Color newColor1 = snow;
                    //Color newColor = newc(newColor1,diff);
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
            }
        }
        return imagePixelated;
    }
    public static BufferedImage island(double[][] island)
    {   BufferedImage imagePixelated = new BufferedImage(island.length,island[0].length, BufferedImage.TYPE_INT_RGB);
        for(int k=0 ; k<island[0].length ; k++)
        {
            for(int j=0 ; j<island.length; j++)
            {   int A=(int)island[j][k];
                if(A>150)
                {
                    Color newColor1 = deepWater;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>125)
                {
                    Color newColor1 = shallowWater;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>110)
                {
                    Color newColor1 = beach;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>50)
                {
                    Color newColor1 = plain;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>25)
                {
                    Color newColor1 = mountain;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else
                {
                    Color newColor1 = snow;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
            }
        }
        return imagePixelated;
    }
}

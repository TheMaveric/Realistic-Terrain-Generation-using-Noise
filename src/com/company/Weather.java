package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Weather {
    public static final Color cloudIn= new Color(255, 255, 255);
    public static final Color cloudOut = new Color(221, 221, 221);
    public static final Color notCloud = new Color(255,255, 255,0);
    public static final Color[] cloud = {cloudIn,cloudOut,notCloud};
    public static BufferedImage weather(double [][] cloud)
    {   BufferedImage imagePixelated = new BufferedImage(cloud.length,cloud[0].length, BufferedImage.TYPE_INT_RGB);
        for(int k=0 ; k<cloud[0].length ; k++)
        {
            for(int j=0 ; j<cloud.length; j++)
            {
                int A=(int)cloud[j][k];
                if(A>150)
                {
                    Color newColor1 = cloudIn;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>130)
                {
                    Color newColor1 = cloudOut;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else
                {
                    Color newColor1 = notCloud;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
            }
        }
        return imagePixelated;
    }
    public static BufferedImage weather(BufferedImage imagePixelated)
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
                {
                    Color newColor1 = cloudIn;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else if(A>130)
                {
                    Color newColor1 = cloudOut;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
                else
                {
                    Color newColor1 = notCloud;
                    imagePixelated.setRGB(j,k,newColor1.getRGB());
                }
            }
        }
        return imagePixelated;
    }
}

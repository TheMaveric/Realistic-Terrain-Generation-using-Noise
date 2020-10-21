package com.company;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class Terrain{
    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
    public static void terrain(){

        try {
            Scanner in= new Scanner(System.in);
            System.out.println("ISLAND");
            System.out.println("Enter dimensions"); //Enter Dimension for image
            int width=in.nextInt();
            int height=in.nextInt();

            double[][] islandArr=new double[width][height];
            islandArr=MakeNoiseIsland.init(width,height,"Island Noise",0.0008); // make island noise profile
            //BufferedImage island = Island.island(islandArr); // give colors to island
            //ImageIO.write(island, "jpg", new File("D:\\Map\\Output\\island.jpg"));

            //System.out.println("CLOUD GENERATED");
            //double[][] cloudArr=new double[width][height];
            //cloudArr=makeNoise.init(width,height,"Cloud Noise",0.007,0,255); // make cloud noise profile
            //BufferedImage cloud=Weather.weather(cloudArr);
            //ImageIO.write(cloud, "jpg", new File("D:\\Map\\Output\\cloud.jpg"));

            System.out.println("HUMIDITY GENERATED");
            double[][] humidity=new double[width][height];
            humidity=MakeNoise.init(width,height,"Humidity Noise",0.0001,0,100,10); // make humidity noise profile

            System.out.println("TEMPERATURE GENERATED");
            double[][] temperature=new double[width][height];
            temperature=MakeNoise.init(width,height,"Moisture Noise",0.0001,0,100,1); // make temperature noise profile

            System.out.println("RIVER GENERATED");
            double[][] riverArr=new double[width][height];
            riverArr=RiverGeneration.init(width,height,"River Noise",0.002,0);
            BufferedImage river=River.river(riverArr);
            ImageIO.write(river, "jpg", new File("D:\\Map\\Output\\River.jpg"));

            System.out.println("BIOME GENERATED");
            BufferedImage biome=Biome.generateBiome(islandArr,temperature,humidity,riverArr);
            ImageIO.write(biome, "jpg", new File("D:\\Map\\Output\\Biome.jpg"));
            /*//BufferedImage moistureArr = ImageIO.read(new File("D:\\Map\\Output\\moisture.jpg"));
            BufferedImage imagePixelated = Pixel.pixelate(img, 1);

            findPath() // TO FIND PATH FROM A,B to C,D USING A STAR ALGORITHM

            combine(cloud,imagePixelated); //combine clouds and island*/
        }
        catch(Exception e){
        }
        System.out.println("END");
    }
    public void combine(BufferedImage weather, BufferedImage island) throws IOException {
        int c = 0;
        for (int i = 0; i < island.getHeight(); i++) {
            BufferedImage ic = Terrain.deepCopy(island);
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
            g1.drawImage(ic, 0, 0, 800, 800, null);
            /*try {
                ImageIO.write(ic, "jpg", new File("D:\\Map\\combined+" + c++ + "+.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
            g1.dispose();
            weather = MoveCloud.rotate(weather);
        }
    }
    public static void main(String[] args) {
                /*MyCanvas m=new MyCanvas();
                JFrame f=new JFrame();
                f.add(m);
                //f.setSize(1400,700);
                f.setPreferredSize(new Dimension(800, 800));
                f.pack();
                f.setVisible(false);
                Pixel obj = new Pixel();*/
                terrain();
    }
}  
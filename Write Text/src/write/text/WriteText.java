/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package write.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author waltersanchez
 */
public class WriteText {
   static int width=200;
   static int height=200;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
          clearOutput();
          String [] names={"Tom Juma","Alan Wanga","Dennis Oliech"};

            
         for(int i=0; i<3;i++)
            {
            BufferedImage bufferedImg=ImageIO.read(new File("/Users/waltersanchez/Desktop/picha/template.png"));
            int h=bufferedImg.getHeight()/2;
            int w =bufferedImg.getWidth()/2;

            Graphics gg=bufferedImg.getGraphics();
            Graphics2D graphics = (Graphics2D) gg;
            graphics.setColor(Color.BLACK);
            Font ff= Font.createFont(Font.TRUETYPE_FONT, new File("/Users/waltersanchez/Desktop/picha/CALIBRIZ.TTF"));
            ff=ff.deriveFont(Font.BOLD,55);
            
            
            GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(ff);

            
            graphics.setFont(ff);
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                                       RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            FontMetrics metrics = graphics.getFontMetrics(graphics.getFont());
            String s = "Mbuvi Jay";
            s=s.toUpperCase();
            
            Rectangle rect=new Rectangle(h, 0, w*2, 60);
            int x = (rect.width - metrics.stringWidth(names[i])) / 2;
              // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
            int y = ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
            
            
           
           
            graphics.drawString(names[i], x, 520); 
            int l=i+1;
            String jina=l+"_"+names[i];
            String root="/Users/waltersanchez/Desktop/output/";
            ImageIO.write(bufferedImg, "png", new File(root+jina+".png"));
               // graphics.drawString(names[0], x, 520);
                //graphics.dispose();
           
            System.err.println("Image Created");
        
    }
    
}

public static void clearOutput(){
 String path="/Users/waltersanchez/Desktop/output/"; 
        File file = new File(path);
        File[] files = file.listFiles(); 
        for (File f:files) 
        {if (f.isFile() && f.exists()) 
            { f.delete();
               System.out.println("successfully deleted");
            }else
        {
            System.out.println("cant delete a file due to open or error");
}       } 
}
}

package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

   // public int worldX, worldY;
    public int x, y;
    public int speed;

    public BufferedImage up1 , up2, down1, down2, left1, left2,left3,left4,left5, left6 ,left7 ;
   public BufferedImage left8, right1, right2, right3, right4, right5,right6,right7,right8;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collision = false;
    public boolean collisionOn;
    
}

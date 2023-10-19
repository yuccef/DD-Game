package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import main.GamePannel;
import main.KeyHandler;

public class Player extends Entity {

    GamePannel gp;
    KeyHandler keyHandler;

    //PLAYER SCREEN POSITION
   // public final int screenX;
   // public final int screenY;

  
    public Player(GamePannel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyHandler = keyH;

        //PLAYER SCREEN POSITION
    //    screenX = gp.screenWidth/2 - gp.tileSize/2;
     //   screenY = gp.screenHight/2 - gp.tileSize/2;

        solidArea = new Rectangle(8, 16, 16, 20);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        //PLAYER WORLD POSITION
       /* worldX = gp.tileSize * 23; 
        worldY = gp.tileSize * 21; */
    	x=150;
        y = 20;
        speed=4;
        direction = "down";
    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/Player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Player/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Player/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Player/run11.png"));
           left2 = ImageIO.read(getClass().getResourceAsStream("/Player/run22.png"));
           left3 = ImageIO.read(getClass().getResourceAsStream("/Player/run33.png"));
           left4 = ImageIO.read(getClass().getResourceAsStream("/Player/run44.png"));
           left5 = ImageIO.read(getClass().getResourceAsStream("/Player/run55.png"));
           left6 = ImageIO.read(getClass().getResourceAsStream("/Player/run66.png"));
           left7= ImageIO.read(getClass().getResourceAsStream("/Player/run77.png"));
           left8= ImageIO.read(getClass().getResourceAsStream("/Player/run88.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Player/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/Player/right3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/Player/right4.png"));
            right5= ImageIO.read(getClass().getResourceAsStream("/Player/right5.png"));
            right6= ImageIO.read(getClass().getResourceAsStream("/Player/right6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/Player/right7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/Player/right8.png"));
        }catch(Exception e){
            System.out.println("Error loading image");
        }
    }

    public void update(){
        if(keyHandler.upPressed == true){
            direction = "up";
           y = y - speed;
        }
        else if(keyHandler.downPressed == true){
            direction = "down";
            y = y + speed;
        }
        else if(keyHandler.leftPressed == true){
            direction = "left";
            x = x - speed;
        }
        else if(keyHandler.rightPressed == true){
            direction = "right";
            x = x + speed;
        }

        //CHECK COLLISION
        collisionOn = false;
        gp.collisionChecker.checkTile(this); //Player is considered as an entity beacause it extends Entity

        //IF COLLISION IS DETECTED, STOP MOVING THE PLAYER
        if(collisionOn == true){
            if(keyHandler.upPressed == true){
                y = y + speed;
            }
            else if(keyHandler.downPressed == true){
                y = y - speed;
            }
            else if(keyHandler.leftPressed == true){
                x = x + speed;
            }
            else if(keyHandler.rightPressed == true){
                x = x - speed;
            }
        }

        spriteCounter++;
        if (keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true || keyHandler.rightPressed == true){
        	if (spriteCounter > 12) {
        	    spriteNum = (spriteNum % 8) + 1;
        	    spriteCounter = 0;
        	}

          /*  if(spriteCounter > 12){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                if(spriteNum == 2){
                    spriteNum = 3;
                }
                else if(spriteNum == 3){
                    spriteNum = 4;
                }else if(spriteNum == 4){
                    spriteNum = 5;
                }else if(spriteNum == 5){
                    spriteNum = 6;
                }else if(spriteNum == 6){
                    spriteNum = 7;
                }else if(spriteNum == 7){
                    spriteNum = 8;
                }else if(spriteNum == 8){
                    spriteNum =1 ;
                
                spriteCounter = 0;
            }   */
        }
    }
     
    public void draw(Graphics2D g2){
//       g2.setColor(Color.WHITE);
//       g2.fillRect(x, y, 30, 30);

        BufferedImage image = null;

        switch(direction){
            case "up":
            	if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                if (spriteNum == 3)
                    image = right3;
                if (spriteNum == 4)
                    image = right4;
                if (spriteNum == 5)
                    image = right5;
                if (spriteNum == 6)
                    image = right6;
                if (spriteNum == 7)
                    image = right7;
                if (spriteNum == 8)
                    image = right8;
                break;
            case "down":
            	if (spriteNum == 1)
                    image = left1;
                else if (spriteNum == 2)
                    image = left2;
                else if (spriteNum == 3)
                    image = left3;
                else if (spriteNum == 4)
                    image = left4;
                else if (spriteNum == 5)
                    image = left5;
                else if (spriteNum == 6)
                    image = left6;
                else if (spriteNum == 7)
                    image = left7;
                else if (spriteNum == 8)
                    image = left8;
                break;
            case "left":
            	if (spriteNum == 1)
                    image = left1;
                else if (spriteNum == 2)
                    image = left2;
                else if (spriteNum == 3)
                    image = left3;
                else if (spriteNum == 4)
                    image = left4;
                else if (spriteNum == 5)
                    image = left5;
                else if (spriteNum == 6)
                    image = left6;
                else if (spriteNum == 7)
                    image = left7;
                else if (spriteNum == 8)
                    image = left8;
                break;
            case "right":
                if (spriteNum == 1)
                    image = right1;
                if (spriteNum == 2)
                    image = right2;
                if (spriteNum == 3)
                    image = right3;
                if (spriteNum == 4)
                    image = right4;
                if (spriteNum == 5)
                    image = right5;
                if (spriteNum == 6)
                    image = right6;
                if (spriteNum == 7)
                    image = right7;
                if (spriteNum == 8)
                    image = right8;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}

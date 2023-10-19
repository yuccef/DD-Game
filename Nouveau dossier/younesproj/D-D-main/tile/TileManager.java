package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePannel;

public class TileManager {
    
    GamePannel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePannel gp){

        this.gp = gp;

        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/Maps/map.txt");
    }

    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Maps/Grass.png"));
            

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Maps/Water.png"));
            tile[1].collision = true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Maps/Ground.jpg"));
            tile[2].collision = true;

        }catch(Exception e){
            System.out.println("Error loading image");
        }
    }

    public void loadMap(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //Lire le fichier

            int col = 0;  
            int row = 0; 
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine(); //Lire la ligne
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" "); //nubers[] = {0,0,0,0,0,0,0,0,0,0}
                    int num = Integer.parseInt(numbers[col]); 
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            System.out.println("Error loading map");
        }
    }

   public void draw(Graphics2D g2){
//      g2.drawImage(tile[0].image, 0, 0,30,30, null);
//      g2.drawImage(tile[1].image, 30, 0,30,30, null);
//      g2.drawImage(tile[2].image, 0, 30,30,30, null);
       
	  // int x =0;
	  // int y=0;
	   int Col = 0;
        int Row = 0;
        
        while(Col < gp.maxScreenCol && Row < gp.maxScreenRow){

            int tileNum = mapTileNum[Col][Row];
           
            //POSITION OF THE TILE IN THE WORLD
          int x = Col * gp.tileSize;  
           int y = Row * gp.tileSize;

                
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            
            Col++;
            x+=gp.tileSize;
            //y+=gp.tileSize;
            if(Col == gp.maxScreenCol){
                Col = 0;
                Row++;
            }
        }
    }
}
 
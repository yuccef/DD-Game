package DrawTheMap;


// import java.io.BufferedReader;
// import java.io.InputStream;
// import java.io.InputStreamReader;

public class MapMaths{

int[][] matrix = {
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
    {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1},
    {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
    {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
    {1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    {1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
    {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},



        {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};

    public   int MATRIX_SIZE = 810;

    //  public int[][]  loadMap( String test ){

  
    //     int Littlematrix[][] = new int[20][20];

    //         for( int i=0; i<20; i++){
    //             for(int j=0; j<20; j++){
    //                 Littlematrix[j][i] = 0;
    //             }
    //         }


    //     try{

    //         InputStream is = getClass().getResourceAsStream(test);
    //         BufferedReader br = new BufferedReader(new InputStreamReader(is)); 


    //         int col = 0;  
    //         int row = 0; 
    //         while(col <20 && row < 20){
    //             String line = br.readLine(); //Lire la ligne
    //             while(col <20){      
    //                 String numbers[] = line.split(" "); 
    //                 int num = Integer.parseInt(numbers[col]); 
    //                 Littlematrix[col][row] = num;
    //                 col++;
    //             }
    //             if (col == 20){
    //                 col = 0;
    //                 row++;
    //             } 
    //         }


    //         br.close();
    //     }catch(Exception e){
    //         System.out.println("Error loading map");
    //     }
    // return transposeMatrix(Littlematrix);
    // }

    // public int[][] CreatTheBigMatrix(int Littlematrix[][]){
    //     int[][] finaleMatrix = new int[800][800];

    //     for (int i = 0; i < 20; i++) {
    //         for (int j = 0; j < 20; j++) {
    //             for (int k = 0; k < 40; k++) {
    //                 for (int l = 0; l < 40; l++) {
    //                     finaleMatrix[j * 40 + k][i * 40 + l] = Littlematrix[j][i];
    //                 }
    //             }
    //         }
    //     }


    //                 return finaleMatrix;


    // }




     public int[][]  loadMap( ){
    return transposeMatrix(matrix);
    }

    public int[][] CreatTheBigMatrix(int Littlematrix[][]){
        int[][] finaleMatrix = new int[800][800];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 40; k++) {
                    for (int l = 0; l < 40; l++) {
                        finaleMatrix[j * 40 + k][i * 40 + l] = Littlematrix[j][i];
                    }
                }
            }
        }


                    return finaleMatrix;


    }
    
    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
    
        int[][] transposedMatrix = new int[columns][rows];
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
    
        return transposedMatrix;
    }

}
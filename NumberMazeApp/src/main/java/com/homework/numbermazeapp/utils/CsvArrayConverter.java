package com.homework.numbermazeapp.utils;


public final class CsvArrayConverter {
        
    public static int[][] convert(String csvText) throws Exception {
        try {            
             String[] lines = csvText.split("\r\n|\r|\n");
             
             int n = lines.length;             
             int[][] maze = new int[n][n];
             
             int x = 0;              
             for(String line : lines) {
                 int y = 0;                  
                 String[] s = line.split(",");
                 for(String pos: s) {
                     int value = Integer.parseInt(pos);
                     if (value < 0 || value > 9) {
                         throw new IllegalArgumentException();  
                     } else
                         maze[x][y] = value;
                     y++;
                  }          
                  x++;                 
             }
             
             return maze;  
             
        } finally {
               
        }       
        
    }
            
    
}

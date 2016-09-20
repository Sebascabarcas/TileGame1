/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32, height1 = 24, width1 = 16;
	
	public static BufferedImage player, dirt, grass, stone, tree, grama, hospital, tienda, arbol2,gym;
        public static BufferedImage[] player_down, player_up, player_left, player_right;
        public static BufferedImage[] btn_start;
        
        
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
		SpriteSheet sheetplayer = new SpriteSheet(ImageLoader.loadImage("/res/textures/dog.png"));
                SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet2.png"));
                SpriteSheet sheetRecursosPng = new SpriteSheet(ImageLoader.loadImage("/res/textures/spritesAmbienteAux.png"));
                btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
      
                player_down = new BufferedImage[4];
                player_up = new BufferedImage[4];
                player_left = new BufferedImage[4];
                player_right = new BufferedImage[4];
                
                 player_down[0] = sheetplayer.crop(0, 0, width1, height1);
        player_down[1] = sheetplayer.crop(width1, 0, width1, height1);
        player_down[2] = sheetplayer.crop(width1*2, 0, width1, height1);
        player_down[3] = sheetplayer.crop(width1*3, 0, width1, height1);
        
        player_left[0] = sheetplayer.crop(0, height1, width1, height1);
        player_left[1] = sheetplayer.crop(width1, height1, width1, height1);
        player_left[2] = sheetplayer.crop(width1*2, height1, width1, height1);
        player_left[3] = sheetplayer.crop(width1*3, height1, width1, height1);
        
        player_right[0] = sheetplayer.crop(0, height1*2, width1, height1);
        player_right[1] = sheetplayer.crop(width1, height1*2, width1, height1);
        player_right[2] = sheetplayer.crop(width1*2, height1*2, width1, height1);
        player_right[3] = sheetplayer.crop(width1*3, height1*2, width1, height1);
        
        player_up[0] = sheetplayer.crop(0, height1*3, width1, height1);
        player_up[1] = sheetplayer.crop(width1, height1*3, width1, height1);
        player_up[2] = sheetplayer.crop(width1*2, height1*3, width1, height1);
        player_up[3] = sheetplayer.crop(width1*3, height1*3, width1, height1);
		//tree = sheet.crop(0, 0, width, height *2);
		dirt = sheet.crop(width, 0, width, height);
		grass = sheetRecursosPng.crop(6, 64, 16, 16);
		stone = sheet.crop(width * 3, 0, width, height);
		//player = sheetplayer.crop(width1, 0, width1, height1);
                grama = sheet1.crop(0, 16, 16, 16);
                
         //Otros
        
        hospital = sheetRecursosPng.crop(7, 157, 83, 72);
        tienda = sheetRecursosPng.crop(13, 248, 68, 66);
        gym = sheetRecursosPng.crop(89, 231, 114, 80);
        tree = sheetRecursosPng.crop(163, 124, 16, 36);
//        arbol = sheetRecursos.crop(163, 124, 16, 36);
//        letrero = sheetRecursos.crop(183, 58, 18, 19);
//        matas = sheetRecursos.crop(35, 147, 17, 17);
//        grass = sheetRecursos.crop(40, 64, 16, 16);
//        matas = sheetRecursos.crop(180, 144, 16, 16);
//        
//        
//        //Definitivos
//        arbolPeq = sheetRecursosTiles.crop(1, 1, 16, 16);//2
//        flores = sheetRecursosTiles.crop(18, 1, 16, 16);//3
//        cercaFro = sheetRecursosTiles.crop(35, 1, 16, 16);//4
//        cercaLat = sheetRecursosTiles.crop(52, 1, 16, 16);//5
//        //MATAS                                           6
//        roca1 = sheetRecursosTiles.crop(1, 18, 16, 16);//7
//        roca2 = sheetRecursosTiles.crop(18, 18, 16, 16);//8
//        roca3 = sheetRecursosTiles.crop(35, 18, 16, 16);//9
//        roca4 = sheetRecursosTiles.crop(1, 35, 16, 16);//10
//        roca5 = sheetRecursosTiles.crop(18, 35, 16, 16);//11
//        roca6 = sheetRecursosTiles.crop(35, 35, 16, 16);//12
//        roca7 = sheetRecursosTiles.crop(1, 52, 16, 16);//13
//        roca8 = sheetRecursosTiles.crop(18, 52, 16, 16);//14
//        roca9 = sheetRecursosTiles.crop(35, 52, 16, 16);//15
//        grassClaro = sheetRecursosTiles.crop(52, 18, 16, 16);//16
//        arena= sheetRecursosTiles.crop(52, 35, 16, 16);//17
//        piedra = sheetRecursosTiles.crop(52, 52, 16, 16);//18
//        agua = sheetRecursosTiles.crop(69, 18, 16, 16);//19
//        grassBorde = sheetRecursosTiles.crop(69, 35, 16, 16); //20
//        letGris= sheetRecursosTiles.crop(69, 1, 16, 16);//21
//        letCafe = sheetRecursosTiles.crop(86, 1, 14, 16);//22
//        letGym = sheetRecursosTiles.crop(101, 1, 18, 22);//23
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.gfx;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Assets {

    private static final int width = 32, height = 32, height1 = 24, width1 = 16;
    public static BufferedImage player, dirt,heal, grass, stone, tree, treebig, grama, hospital, escoger, tienda, arbol2, gym, batalla, flores, moves, hp,textinput;
    public static BufferedImage[] player_down, player_up, player_left, player_right, pokemonsfront, pokemonsback;
    public static BufferedImage[] btn_start, run, fight, bag, pokemones, Blankspace;
    public static Image menu; //= new ImageIcon("/res/textures/menu.gif").getImage();
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
        SpriteSheet sheetplayer = new SpriteSheet(ImageLoader.loadImage("/res/textures/dog.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet2.png"));
        SpriteSheet sheetRecursosPng = new SpriteSheet(ImageLoader.loadImage("/res/textures/spritesAmbienteAux.png"));
        SpriteSheet bb = new SpriteSheet(ImageLoader.loadImage("/res/textures/bb.png"));
        SpriteSheet rb = new SpriteSheet(ImageLoader.loadImage("/res/textures/rb.png"));
       // SpriteSheet sb = new SpriteSheet(ImageLoader.loadImage("/res/textures/rb.png"));
        SpriteSheet fb = new SpriteSheet(ImageLoader.loadImage("/res/textures/fb.png"));
        SpriteSheet bagb = new SpriteSheet(ImageLoader.loadImage("/res/textures/bagb.png"));
        SpriteSheet pb = new SpriteSheet(ImageLoader.loadImage("/res/textures/pb.png"));
        SpriteSheet treeM = new SpriteSheet(ImageLoader.loadImage("/res/textures/TreeMedium.png"));
        SpriteSheet rock = new SpriteSheet(ImageLoader.loadImage("/res/textures/rock1.png"));
        SpriteSheet Grass = new SpriteSheet(ImageLoader.loadImage("/res/textures/Grass.png"));
        SpriteSheet Flower = new SpriteSheet(ImageLoader.loadImage("/res/textures/Planta4.png"));
        SpriteSheet Moves = new SpriteSheet(ImageLoader.loadImage("/res/textures/Moves.png"));
        SpriteSheet blankSpace = new SpriteSheet(ImageLoader.loadImage("/res/textures/BlankSpace.png"));
       
        pokemonsfront = new BufferedImage[152];
        for (int i = 1; i <= 151; i++) {
                    
                      pokemonsfront[i]= ImageLoader.loadImage("/res/textures/Sprites/Sprites 151/"+i+".png").getSubimage(0, 0, 80, 80);
                    
        }
         pokemonsback = new BufferedImage[152];
        for (int i = 1; i <= 151; i++) {
                    
                    pokemonsback[i]= ImageLoader.loadImage("/res/textures/Sprites/BS/"+i+".png").getSubimage(0, 0, 64, 64);
                    
        } 
        
       
        hp = ImageLoader.loadImage("/res/textures/hp.png").getSubimage(0, 1, 8, 1);
        menu = ImageLoader.loadImage("/res/textures/m.png");
        escoger = ImageLoader.loadImage("/res/textures/escoger.png");
        textinput = ImageLoader.loadImage("/res/textures/tinput.png").getSubimage(0, 0, 240, 160);
        heal = ImageLoader.loadImage("/res/textures/heal.png");
        moves= Moves.crop(0, 0, 240 , 48);
        
        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
        btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);
        
        Blankspace = new BufferedImage[2];
        Blankspace[0] = blankSpace.crop(0, 0,16,48);
        Blankspace[1] = blankSpace.crop(0, 0, 16, 48);
        run = new BufferedImage[2];
        run[0] = rb.crop(0, 0, 54, 18);
        run[1] = rb.crop(54, 0, 54, 18);

        fight = new BufferedImage[2];
        fight[0] = fb.crop(0, 0, 54, 18);
        fight[1] = fb.crop(54, 0, 54, 18);

        bag = new BufferedImage[2];
        bag[0] = bagb.crop(0, 0, 54, 18);
        bag[1] = bagb.crop(54, 0, 54, 18);

        pokemones = new BufferedImage[2];
        pokemones[0] = pb.crop(0, 0, 54, 18);
        pokemones[1] = pb.crop(54, 0, 54, 18);

        batalla = bb.crop(0, 0, 240, 160);

        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];

        player_down[0] = sheetplayer.crop(0, 0, width1, height1);
        player_down[1] = sheetplayer.crop(width1, 0, width1, height1);
        player_down[2] = sheetplayer.crop(width1 * 2, 0, width1, height1);
        player_down[3] = sheetplayer.crop(width1 * 3, 0, width1, height1);

        player_left[0] = sheetplayer.crop(0, height1, width1, height1);
        player_left[1] = sheetplayer.crop(width1, height1, width1, height1);
        player_left[2] = sheetplayer.crop(width1 * 2, height1, width1, height1);
        player_left[3] = sheetplayer.crop(width1 * 3, height1, width1, height1);

        player_right[0] = sheetplayer.crop(0, height1 * 2, width1, height1);
        player_right[1] = sheetplayer.crop(width1, height1 * 2, width1, height1);
        player_right[2] = sheetplayer.crop(width1 * 2, height1 * 2, width1, height1);
        player_right[3] = sheetplayer.crop(width1 * 3, height1 * 2, width1, height1);

        player_up[0] = sheetplayer.crop(0, height1 * 3, width1, height1);
        player_up[1] = sheetplayer.crop(width1, height1 * 3, width1, height1);
        player_up[2] = sheetplayer.crop(width1 * 2, height1 * 3, width1, height1);
        player_up[3] = sheetplayer.crop(width1 * 3, height1 * 3, width1, height1);
        //tree = sheet.crop(0, 0, width, height *2);
        dirt = sheetRecursosPng.crop(242, 112, 7, 7);
        grass = sheetRecursosPng.crop(6, 64, 16, 16);
        stone = rock.crop(0, 0, 16, 16);
        //player = sheetplayer.crop(width1, 0, width1, height1);
        grama = sheet1.crop(0, 16, 16, 16);

         //Otros
        hospital = sheetRecursosPng.crop(7, 157, 83, 72);
        tienda = sheetRecursosPng.crop(13, 248, 68, 66);
        gym = sheetRecursosPng.crop(89, 231, 114, 80);
        tree = treeM.crop(0, 0, 32, 48);
       
//        arbol = sheetRecursos.crop(163, 124, 16, 36);
//        letrero = sheetRecursos.crop(183, 58, 18, 19);
//        matas = sheetRecursos.crop(35, 147, 17, 17);
//        grass = sheetRecursos.crop(40, 64, 16, 16);
//        matas = sheetRecursos.crop(180, 144, 16, 16);
//        
//        
//        //Definitivos
//        arbolPeq = sheetRecursosTiles.crop(1, 1, 16, 16);//2
          flores = Flower.crop(0, 0, 16, 16);
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

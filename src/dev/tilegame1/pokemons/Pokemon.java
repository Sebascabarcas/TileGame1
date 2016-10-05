/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.pokemons;

import static dev.tilegame1.gfx.Assets.moves;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static sun.org.mozilla.javascript.internal.ScriptRuntime.name;

/**
 *
 * @author SebastianCabarcas
 */

public class Pokemon {
    private Pokemon[] pokemonList;
    private String[] s1;
    private String[] s2;
    private String[] s3;
    private int id;
    private int bHp;
    private int bAtt;
    private int bDef;
    private int bSpd;
    private int bAttSp;
    private int bDefSp;
    private int catchR;
    private int xp;
    private int happ;
    private int effHp;
    private int effAtt;
    private int effDef;
    private int effSpd;
    private int effAttSp;
    private int effDefSpp;
    private float height;
    private float weight;
    private String genderR;
    private String name;
    private String iName;
    private String kind;
    private String pInfo;
    private String type1;
    private String type2;
    private String growR;
    private int StepsTH;
    private String color;
    private String habitat;
    private String moves;
    private String ev;
    
    
    
    public Pokemon(int id, int bHp,int bAtt,int bDef,int bSpd,int bAttSp,int bDefSp,int catchR,
            int xp,int happ,int effHp,int effAtt,int effDef,int effSpd,int effAttSp,int effDefSpp,float height,float weight,String genderR,
            String name,String iName,String kind,String pInfo,String type1,String type2,String growR,int StepsTH,String color,String habitat,
            String moves,String ev){//, pokemonBack, pokemonFront, pokemonIcon){
     
    }
    public void loadAllPokemons(){
        for (int i = 0; i < 151; i++) {
            try {
               
               pokemonList[i] = readPokemon(i +1);
            } catch (Exception ex) {
               Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Pokemon readPokemon(int id) throws Exception{
        //int counter = 1;
        String idS = Integer.toString(id);
        
        File file = new File("txt/pokemon.txt");
        Scanner pokemon = new Scanner(file);

        while(pokemon.hasNextLine()){
            String line = pokemon.nextLine();
            s1 = line.split("\\|");
            s2 = s1[0].split("=");
            if (s2[1].equals(idS)) {
                break;
            }
        }
         for (int i = 0; i < 22; i++) {
             s2 = s1[i].split("=");
             s3[i] = s2[1];
         }
         this.id = id;
         this.name = s3[1];
         this.iName = s3[2];
         this.kind = s3[3];
         this.pInfo = s3[4];
         this.type1 = s3[5];
         this.type2 = s3[6];
         s2 = s3[7].split(",");
         this.bHp = Integer.parseInt(s2[0]);
         this.bAtt = Integer.parseInt(s2[1]);
         this.bDef = Integer.parseInt(s2[2]);
         this.bSpd = Integer.parseInt(s2[3]);
         this.bAttSp = Integer.parseInt(s2[4]);
         this.bDefSp = Integer.parseInt(s2[5]);
         this.catchR = Integer.parseInt(s3[8]);
         this.xp = Integer.parseInt(s3[9]);
         this.happ = Integer.parseInt(s3[10]);
         this.growR = s3[11];
         this.StepsTH = Integer.parseInt(s3[12]);
         this.color = s3[13];
         this.habitat = s3[14];
         s2 = s3[15].split(",");
         this.effHp = Integer.parseInt(s2[0]);
         this.effAtt = Integer.parseInt(s2[1]);
         this.effDef = Integer.parseInt(s2[2]);
         this.effSpd = Integer.parseInt(s2[3]);
         this.effAttSp = Integer.parseInt(s2[4]);
         this.effDefSpp = Integer.parseInt(s2[5]);
         //this.comp = s3[16];
         this.height = Float.parseFloat(s3[17]);
         this.weight = Float.parseFloat(s3[18]);
         this.genderR = s3[19];
         this.moves = s3[20];
         this.ev = s3[21];
         
        //this.pokemonBack = new ImageIcon("Shinys/Back/"+id+".png").getImage();
        //this.pokemonFront = new ImageIcon("Shinys/Front/"+id+".png").getImage();
        //this.pokemonIcon = new ImageIcon("Shinys/Icons/"+id+".png").getImage();
        
        //movesLvl = null; 
        //mName = null;
        
         System.out.println("12");
         Pokemon p = new Pokemon(this.id, bHp, bAtt, bDef, bSpd, bAttSp, bDefSp,
                 catchR, xp,  happ, effHp, effAtt, effDef, effSpd, effAttSp,
                 effDefSpp, height, weight, genderR, name, iName, kind, pInfo,
                 type1, type2, growR, StepsTH, color, habitat, moves, ev); 
                 //pokemonBack, pokemonFront, pokemonIcon);
         
       
         return p;
    }
}

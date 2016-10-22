/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.pokemons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author SebastianCabarcas
 */
public class Loader {
    //Variables pokemones
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
    private  int effAttSp;
    private  int effDefSpp;
    private  float height;
    private float weight;
    private  int StepsTH;
    private String genderR, name, iName, kind, pInfo,type1,type2, growR, color, habitat, moves,ev;
     private int hp;
    private int att;
    private int def;
    private int Spd;
    private int AttSp;
    private int DefSp;
    
    //Variables moves
    private PokemonMov[] pokemonListM;
    private int Idmove;
    private String nameIMov;
    private String nameMov;
    private String effM;
    private int bPow;
    private String TypeM;
    private String damCat;
    private int accu;
    private int TotalPP;
    private int addeffc;
    private int target;
    private String descrip;
    private String flags;
    private int prio;
   
    //Variables tipos
    private PokemonType[] pokemonListType;
    private int IdType;
    private String nameType;
    private String InameType;
    private String specialType;
    private String weaknesses;
    private String resistances;
    private String inmunities;
    
     public Pokemon[] readPokemon() throws Exception{
        int counter = 1;
        s3 = new String[22];
        pokemonList = new Pokemon[152];
        //String idS = Integer.toString(id);
       
        File file = new File("res/worlds/pokemon.txt");
        Scanner pokemon = new Scanner(file);

        while(pokemon.hasNextLine()){
           // System.out.println("lolo");
            String line = pokemon.nextLine();
          // System.out.println(line);
            s1 = line.split("\\|");
            //s2 = s1[0].split("=");
           //System.out.println(s1[0]);
            //System.out.println(s1[0]);
            //System.out.println(s2[1]);
           // if (s2[1].equals(idS)) {
             //   break;
           // }
       
         for (int i = 0; i < 22; i++) {
             s2 = s1[i].split("=");
           //  System.out.println(s2[0]);
             s3[i] = s2[1];
           
         }
         this.id = Integer.parseInt(s3[0]);
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
          
     
       pokemonList[counter]=new Pokemon(id, bHp, bAtt, bDef, bSpd, bAttSp, bDefSp,
                 catchR, xp,  happ, effHp, effAtt, effDef, effSpd, effAttSp,
                 effDefSpp, height, weight, genderR, name, iName, kind, pInfo,
                 type1, type2, growR, StepsTH, color, habitat, moves, ev);
        counter = counter + 1;
        
        
        }
       /* Pokemon p = new Pokemon(this.id, bHp, bAtt, bDef, bSpd, bAttSp, bDefSp,
                 catchR, xp,  happ, effHp, effAtt, effDef, effSpd, effAttSp,
                 effDefSpp, height, weight, genderR, name, iName, kind, pInfo,
                 type1, type2, growR, StepsTH, color, habitat, moves, ev); */
                 //pokemonBack, pokemonFront, pokemonIcon);
         
        
         return pokemonList;
    }
     public void genStats(int id){
    
   
    hp = ((pokemonList[id].getbHp())*2+10)/100;
    
    
    
    }
     public PokemonMov[] readMov() throws FileNotFoundException{
     
         int counter = 1;
        s3 = new String[14];
       // s1 = new String[14];
        pokemonListM = new PokemonMov[622];
      
       
        File file = new File("res/worlds/listMoves.txt");
        Scanner pokemon = new Scanner(file);

        while(pokemon.hasNextLine()){
           // System.out.println("lolo");
            String line = pokemon.nextLine();
           
           s1 = line.split(";");
           
        
          //  s2 = s1[0];
            
            for (int i = 0; i < 13; i++) {
            s2 = s1[i+1].split("=");
           // System.out.println(s1[i].split("="));
           // s3[0] = s2[0];
                if (s2[1]==""){
                    s3[i+1]="null";
                }else{
             s3[i+1] = s2[1];
                }
           
         }
         
     this.IdType =counter;
    this.nameIMov = s3[1];
    this.nameMov = s3[2];
    this.effM =s3[4];
    this.bPow =Integer.parseInt(s3[3]);
    this.TypeM = s3[5];
    this.damCat = s3[6];
    this.accu = Integer.parseInt(s3[8]);
    this.TotalPP = Integer.parseInt(s3[8]);
    this.addeffc = Integer.parseInt(s3[9]);
    this.target = Integer.parseInt(s3[10]); 
    this.descrip = s3[7];
    this.flags = s3[13];
    this.prio = Integer.parseInt(s3[12]);
   
    pokemonListM[counter] = new PokemonMov(Idmove, nameIMov, nameMov, effM, bPow, TypeM, damCat, accu, TotalPP, addeffc, target,
            descrip, flags, prio);
      
    counter = counter + 1;
        
     }
        return pokemonListM; 
    } 
     
     
      public PokemonType[] readType() throws FileNotFoundException{
     
         int counter = 0;
         s3 = new String[7];
       // s1 = new String[14];
        pokemonListType = new PokemonType[20];
      
       
        File file = new File("res/worlds/types.txt");
        Scanner pokemon = new Scanner(file);

        while(pokemon.hasNextLine()){
           // System.out.println("lolo");
            String line = pokemon.nextLine();
           s1 = line.split(";");
           
        
          //  s2 = s1[0];
            
            for (int i = 0; i < 6; i++) {
            s2 = s1[i].split("=");
           // System.out.println(s1[i].split("="));
           // s3[0] = s2[0];
                
             s3[i] = s2[1];
               
         }
         
    this.IdType=Integer.parseInt(s3[0]); 
    this.nameType=s3[1];
    this.InameType=s3[2];
    this.specialType=s3[3];
    this.weaknesses= s3[4];
    this.resistances=s3[5];
    this.inmunities=s3[6];
   
    pokemonListType[counter] = new PokemonType(IdType , nameType, InameType, specialType, weaknesses, resistances, inmunities);
      
    counter = counter + 1;
        
     }
        return pokemonListType; 
    } 
}

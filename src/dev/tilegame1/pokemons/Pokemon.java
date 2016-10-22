/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.tilegame1.pokemons;

/**
 *
 * @author SebastianCabarcas
 */

public class Pokemon {

   
    //private Pokemon[] pokemonList;
   // private String[] s1;
    //private String[] s2;
   // private String[] s3;
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
    private String genderR;
    private String name; 
    private String iName;
    private String kind;
    private String pInfo;
    private String type1;
    private String type2;
    private String growR;
    private String color;
    private String habitat;
    private String moves;
    private String ev;
    private int hp;
    private int Att;
    private int def;
    private int Spd;
    private int AttSp;
    private int DefSp;
    private int level;
    
    
    public Pokemon(int id, int bHp,int bAtt,int bDef,int bSpd,int bAttSp,int bDefSp,int catchR,
            int xp,int happ,int effHp,int effAtt,int effDef,int effSpd,int effAttSp,int effDefSpp,float height,float weight,String genderR,
            String name,String iName,String kind,String pInfo,String type1,String type2,String growR,int StepsTH,String color,String habitat,
            String moves,String ev){
     //, pokemonBack, pokemonFront, pokemonIcon){
          this.id = id;
          this.bHp = bHp;
          this.bAtt = bAtt;
          this.bDef = bDef;
          this.bSpd = bSpd;
          this.bAttSp = bAttSp;
          this.bDefSp = bDefSp;
          this.catchR = catchR;
          this.xp = xp;
          this.happ = happ;
          this.effHp = effHp;
          this.effAtt = effAtt;
          this.effDef = effDef;
          this.effAttSp = effSpd;
          this.effDefSpp = effDefSpp;
          this.height = height;
          this.weight = weight;
          this.genderR = genderR;
          this.name = name;
          this.kind = kind;
          this.pInfo = pInfo;
          this.type1 = type1;
          this.type2 = type2;
          this.growR = growR;
          this.StepsTH = StepsTH;
          this.color = color;
          this.habitat = habitat;
          this.moves = moves;
          this.ev = ev;
          this.level = 5;
          this.hp =(((2 * this.bHp * this.getLevel()) / 100) + this.getLevel() + 10);
          this.Att = (((2 * this.bAtt  * this.getLevel()) / 100) + 5);
	  this.def = (((2 * this.bDef * this.getLevel()) / 100) + 5);
	  this.Spd = (((2 * this.bSpd * this.getLevel()) / 100) + 5);
	  this.AttSp = (((2 * this.bAttSp * this.getLevel()) / 100) + 5);
	  this.DefSp = (((2 * this.DefSp * this.getLevel()) / 100) + 5);
	        
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtt() {
        return Att;
    }

    public void setAtt(int att) {
        this.Att = att;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpd() {
        return Spd;
    }

    public void setSpd(int Spd) {
        this.Spd = Spd;
    }

    public int getAttSp() {
        return AttSp;
    }

    public void setAttSp(int AttSp) {
        this.AttSp = AttSp;
    }

    public int getDefSp() {
        return DefSp;
    }

    public void setDefSp(int DefSp) {
        this.DefSp = DefSp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void Levelup(){
    this.level = level + 1;
    
    }
    
    public void updateStats(){
                this.hp = (((2 * this.bHp  * this.getLevel()) / 100) + this.getLevel() + 10);
		this.Att = (((2 * this.bAtt * this.getLevel()) / 100) + 5);
		this.def = (((2 * this.bDef  * this.getLevel()) / 100) + 5);
		this.AttSp = (((2 * this.bAttSp * this.getLevel()) / 100) + 5);
		this.DefSp = (((2 * this.bDefSp  * this.getLevel()) / 100) + 5);
		this.Spd = (((2 * this.bSpd * this.getLevel()) / 100) + 5);
    }
    
    
    /*
    public void loadAllPokemons(){ 
     //  pokemonList = new Pokemon[151];
        for (int i = 0; i < 151; i++) {
            try {
               
               //pokemonList[i] = readPokemon(i +1);
            } catch (Exception ex) {
               Logger.getLogger(Pokemon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void readPokemon(int id) throws Exception{
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
        
        Pokemon p = new Pokemon(this.id, bHp, bAtt, bDef, bSpd, bAttSp, bDefSp,
                 catchR, xp,  happ, effHp, effAtt, effDef, effSpd, effAttSp,
                 effDefSpp, height, weight, genderR, name, iName, kind, pInfo,
                 type1, type2, growR, StepsTH, color, habitat, moves, ev); 
                 //pokemonBack, pokemonFront, pokemonIcon);
         
       
         return p;
    }
    */

    public int getId() {
        return id;
    }
   

    public void setId(int id) {
        this.id = id;
    }

    public int getbHp() {
        return bHp;
    }

    public void setbHp(int bHp) {
        this.bHp = bHp;
    }

    public int getbAtt() {
        return bAtt;
    }

    public void setbAtt(int bAtt) {
        this.bAtt = bAtt;
    }

    public int getbDef() {
        return bDef;
    }

    public void setbDef(int bDef) {
        this.bDef = bDef;
    }

    public int getbSpd() {
        return bSpd;
    }

    public void setbSpd(int bSpd) {
        this.bSpd = bSpd;
    }

    public int getbAttSp() {
        return bAttSp;
    }

    public void setbAttSp(int bAttSp) {
        this.bAttSp = bAttSp;
    }

    public int getbDefSp() {
        return bDefSp;
    }

    public void setbDefSp(int bDefSp) {
        this.bDefSp = bDefSp;
    }

    public int getCatchR() {
        return catchR;
    }

    public void setCatchR(int catchR) {
        this.catchR = catchR;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getHapp() {
        return happ;
    }

    public void setHapp(int happ) {
        this.happ = happ;
    }

    public int getEffHp() {
        return effHp;
    }

    public void setEffHp(int effHp) {
        this.effHp = effHp;
    }

    public int getEffAtt() {
        return effAtt;
    }

    public void setEffAtt(int effAtt) {
        this.effAtt = effAtt;
    }

    public int getEffDef() {
        return effDef;
    }

    public void setEffDef(int effDef) {
        this.effDef = effDef;
    }

    public int getEffSpd() {
        return effSpd;
    }

    public void setEffSpd(int effSpd) {
        this.effSpd = effSpd;
    }

    public int getEffAttSp() {
        return effAttSp;
    }

    public void setEffAttSp(int effAttSp) {
        this.effAttSp = effAttSp;
    }

    public int getEffDefSpp() {
        return effDefSpp;
    }

    public void setEffDefSpp(int effDefSpp) {
        this.effDefSpp = effDefSpp;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getStepsTH() {
        return StepsTH;
    }

    public void setStepsTH(int StepsTH) {
        this.StepsTH = StepsTH;
    }

    public String getGenderR() {
        return genderR;
    }

    public void setGenderR(String genderR) {
        this.genderR = genderR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getGrowR() {
        return growR;
    }

    public void setGrowR(String growR) {
        this.growR = growR;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getMoves() {
        return moves;
    }

    public void setMoves(String moves) {
        this.moves = moves;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    
}